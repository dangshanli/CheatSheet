package chapter4;

import java.util.concurrent.TimeUnit;

/**
 * @author luzj
 * @description: join()的使用
 * 0 在内部调用xxxThread.join()的线程进入等待状态
 * 1 xxxThread开始执行，直到xxxThread执行完毕，该线程调用notifyAll()唤起所有线程
 * 2 join的实现原理就是等待/唤醒范式
 * @date 2018/10/9
 */
public class Join {
    public static void main(String[] args) throws InterruptedException {
        Thread previous = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Domino(previous),"Domino"+String.valueOf(i));
            thread.start();
            previous = thread;
        }

        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName()+" terminate.");
    }

    static class Domino implements Runnable {
        private Thread thread;

        public Domino(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " terminate.");
        }
    }
}
