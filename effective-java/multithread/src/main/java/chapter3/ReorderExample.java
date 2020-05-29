package chapter3;

/**
 * @author luzj
 * @description: 指令重排序
 * @date 2018/10/4
 */
public class ReorderExample {
    int a = 0;
    boolean flag = false;

    public void write() {
        a = 1;
        flag = true;
    }

    public void reader() {
        if (flag) {
            int i = a * a;
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            ReorderExample example = new ReorderExample();
            Thread t1 = new Thread(() -> {
                example.write();
            });

            Thread t2 = new Thread(() -> {
                example.reader();
            });

            t1.start();
            t2.start();
        }

    }

}
