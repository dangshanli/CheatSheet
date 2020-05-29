package chapter3;

/**
 * @author luzj
 * @description:
 * @date 2018/10/4
 */
public class VolatileExample {
    int a = 0;
    volatile boolean flag = false;

    public void write() {
        a = 1;
        flag = true;
    }

    public void reader() {
        if (flag) {
            int i = a;
            System.out.println(i);
        }
    }

    public static void main(String[] args) {

        VolatileExample example = new VolatileExample();
        Thread t1 = new Thread(() -> {
            example.write();
        });

        Thread t2 = new Thread(() -> {
            example.reader();
        });
        t2.start();
        t1.start();
    }
}
