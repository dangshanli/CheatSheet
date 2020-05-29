package chapter4;

/**
 * @author luzj
 * @description: 线程状态：new running(running || ready) blocked(等待获取锁) waiting(等待被其他线程唤醒) time_waiting(等待被唤醒或者超时) terminated
 * 0 使用jstack <pid></>可以查看
 * @date 2018/10/8
 */
public class ThreadState {

    public static void main(String[] args) {
        new Thread(new TimeWaiting(),"time_waiting_thread").start();
        new Thread(new Waiting(),"waiting_thread").start();
        new Thread(new Blocked(),"blocked_thread1").start();
        new Thread(new Blocked(),"blocked_thread2").start();
    }

    static class TimeWaiting implements Runnable {
        @Override
        public void run() {
            while (true) {
                SleepUtils.second(100);
            }
        }
    }

    static class Waiting implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (Waiting.class) {
                    try {
                        Waiting.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class Blocked implements Runnable {
        @Override
        public void run() {
            synchronized (Blocked.class) {
                while (true) {
                    SleepUtils.second(100);
                }
            }
        }
    }


}
