package chapter4;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author luzj
 * @description: suspend() resume() stop(),暂停 回复 停止，过期的api
 * 因为suspend之后还会持有锁，可能会造成死锁，stop之后几乎没有机会释放资源，可能造成线程状态不可知
 * @date 2018/10/9
 */
public class Deprecated {
    public static void main(String[] args) throws InterruptedException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Thread printThread = new Thread(new Runner(), "print_runner_Thread");
        printThread.setDaemon(true);
        printThread.start();

        TimeUnit.SECONDS.sleep(3);
        printThread.suspend();
        System.out.println("main suspend at " + dateFormat.format(new Date()));

        TimeUnit.SECONDS.sleep(3);
        printThread.resume();
        System.out.println("main resume at " + dateFormat.format(new Date()));

        TimeUnit.SECONDS.sleep(3);
        printThread.stop();
        System.out.println("main stop at" + dateFormat.format(new Date()));
        TimeUnit.SECONDS.sleep(3);
    }

    static class Runner implements Runnable {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

        @Override
        public void run() {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " run at" + dateFormat.format(new Date()));
                SleepUtils.second(1);
            }
        }
    }
}
