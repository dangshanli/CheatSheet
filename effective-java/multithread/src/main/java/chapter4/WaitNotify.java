package chapter4;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author luzj
 * @description: 等待通知模式
 * 0 调用wait()的线程会进入wait状态，只有等待其他线程调用notify()才能唤醒
 * 1 线程wait状态后会释放当前持有的锁
 * 2 线程持有的锁就是等待的对象
 * 3 线程被notify后，会进入阻塞，只有再次获得锁才能继续执行
 * @date 2018/10/9
 */
public class WaitNotify {
    static boolean flag = true;
    static Object lock = new Object();//用作锁的对象

    public static void main(String[] args) throws InterruptedException {
        Thread wait = new Thread(new Wait(),"wait_thread");
        wait.start();
        TimeUnit.SECONDS.sleep(1);

        Thread notify = new Thread(new Notify(),"notify_thread");
        notify.start();
    }

    //等待线程
    static class Wait implements Runnable{
        @Override
        public void run() {
            synchronized (lock){//在lock上等待，就必须拿lock作为锁
                while (flag){
                    try {
                        System.out.println(Thread.currentThread()+ "flag is true.wait@"+
                                new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        lock.wait();//wait()操作使当前线程进入wait状态，且失去lock锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread()+" flag is false.running@"+
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }

    //通知线程
    static  class Notify implements Runnable{
        @Override
        public void run() {
            synchronized (lock){//只有等当前线程释放锁，wait线程才能返回，继续执行
                System.out.println(Thread.currentThread()+" hold lock.notify@"+
                new SimpleDateFormat("HH:mm:ss").format(new Date()));
                lock.notifyAll();//notify()操作唤醒等在lock对象上的线程，使他们由等待进入阻塞状态
                flag = false;
                SleepUtils.second(5);
            }

            //此时，lock锁时自由的，但显然从输出结果看，大部分时候，该线程又竞争成功了
            synchronized (lock){
                System.out.println(Thread.currentThread()+" hold lock again.sleep@"+
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
                SleepUtils.second(5);
            }
        }
    }

}
