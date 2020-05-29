package chapter4;

import java.util.concurrent.TimeUnit;

/**
 * @author luzj
 * @description: 安全的终止线程
 * 0 通过中断标识来关闭线程
 * 1 通过设置一个Boolean变量来表示线程开关，其道理和中断差不多
 * 2 注意：中断不是像stop()一样突然强行关闭线程，他只是一个标识位
 * 3 通过这种利用标识关闭的线程的方式，可以给线程反应时间，做好资源的释放等后续工作
 * @date 2018/10/9
 */
public class ShutDown {
    public static void main(String[] args) throws InterruptedException {
        Runner one = new Runner();
        Thread countThread = new Thread(one,"CountThread");
        countThread.start();
        TimeUnit.SECONDS.sleep(1);
        countThread.interrupt();//通过中断关闭结束线程

        Runner two = new Runner();
        countThread = new Thread(two,"CountThread");
        countThread.start();
        TimeUnit.SECONDS.sleep(1);
        two.cancel();
    }

    static class Runner implements Runnable {
        private long i;
        private volatile boolean on = true;
        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println("Count i:" + i);
        }

        public void cancel(){
            on = false;
        }
    }
}
