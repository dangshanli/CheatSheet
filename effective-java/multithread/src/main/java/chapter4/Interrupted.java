package chapter4;

import java.util.concurrent.TimeUnit;

/**
 * @author luzj
 * @description: 线程中断测试
 * 0 busy一直在跑 ，sleep线程一直在睡
 * 1 对两者进行终端操作
 * 2 观察二者的终端标识位
 * 3 sleep线程抛出中断异常，导致其中断标识复位，因此sleep最后为false
 * 4 busy线程为true，表示已经加入中断标识
 * @date 2018/10/9
 */
public class Interrupted {
    public static void main(String[] args) throws InterruptedException {
        Thread busy = new Thread(new BusyRunner(), "busy_thread");
        Thread sleep = new Thread(new SleepRunner(), "sleep_thread");
        sleep.setDaemon(true);
        busy.setDaemon(true);
        sleep.start();
        busy.start();

        TimeUnit.SECONDS.sleep(5);
        sleep.interrupt();
        busy.interrupt();
        System.out.println("sleep interrupted:" + sleep.isInterrupted());
        System.out.println("busy interrupted:" + busy.isInterrupted());
        TimeUnit.SECONDS.sleep(2);
    }

    //一直在睡
    static class SleepRunner implements Runnable {

        @Override
        public void run() {
            while (true) {
                SleepUtils.second(10);
            }
        }
    }

    //一直在跑
    static class BusyRunner implements Runnable {

        @Override
        public void run() {
            while (true) {
            }
        }
    }


}
