package chapter3;

/**
 * @author luzj
 * @description: 同步程序的顺序一致性
 * @date 2018/10/4
 */
public class SynchronizedExample {
    int a = 0;
    boolean flag = false;

    public synchronized void writer() {
        a = 1;
        flag = true;
    }

    public synchronized void reader() {
        if (flag) {
            int i = a;
            System.out.println(i);
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            SynchronizedExample example = new SynchronizedExample();
            Thread t1 = new Thread(() -> {
                example.writer();
            });

            Thread t2 = new Thread(() -> {
                example.reader();
            });
            t1.start();
            t2.start();
        }
    }
}
