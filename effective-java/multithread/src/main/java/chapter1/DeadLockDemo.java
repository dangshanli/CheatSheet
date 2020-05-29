package chapter1;

/**
 * @author luzj
 * @description: 演示死锁
 * 0 t1首先拿到锁 A
 * 1 同时t2拿到锁B
 * 2 接着，t1如果想运行下去需要锁B，同理t2需要锁A才能释放B出来
 * 3 最终，死锁形成
 * @date 2018/9/28
 */
public class DeadLockDemo {
    private static String A = "A";
    private static String B = "B";

    public static void main(String[] args) {
//        new DeadLockDemo().deadLock();
        new DeadLockDemo().syncLock();
    }

    //死锁
    private void deadLock() {
        Thread t1 = new Thread(() -> {
            synchronized (A) {
                try {
                    Thread.currentThread().sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (B) {
                    System.out.println("1");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (B) {
                synchronized (A) {
                    System.out.println("2");
                }
            }
        });

        t1.start();
        t2.start();
    }

    /**
     * 测试当一个变量作为sync的锁时，在没有被释放的时候，是否还能被访问
     * 结果是，可以
     */
    private void syncLock() {
        Thread t1 = new Thread(() -> {
            synchronized (A) {
                try {
                    Thread.currentThread().sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(B);
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (B) {
                System.out.println("----");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("++++");
            }
        });
        t1.start();
        t2.start();
    }
}
