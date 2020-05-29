package chapter4;

/**
 * @author luzj
 * @description: Daemon Thread 作为前台线程的支持线程，如果前台线程全部关闭，则虚拟机退出，后台也将关闭
 * 0 本例子展示，后台进程的finally也一定会执行
 * @date 2018/10/9
 */
public class Daemon {
    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonRunner(), "DaemonThread");
        thread.setDaemon(true);
        thread.start();
    }

    static class DaemonRunner implements Runnable {

        @Override
        public void run() {
            try {
                SleepUtils.second(100);
            } finally {
                System.out.println("daemon thread finally run.");
            }
        }
    }
}
