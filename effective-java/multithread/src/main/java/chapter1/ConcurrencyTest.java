package chapter1;

/**
 * @author luzj
 * @description: 并发速度测试
 * 0 不知道是否因为jvm会将单线程代码进行多线程优化，单线程很多时候比多线程快
 * 1 多线程相比单线程会有额外的开销：上下文切换、线程创建
 * 2 由于以上原因，多线程不见得比单线程快
 * @date 2018/9/28
 */
public class ConcurrencyTest {
    private static final long count = 100001l;

    //数值累加
    public static void main(String[] args) throws InterruptedException {
        concurrency();
        serial();
    }

    //单线程
    private static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(() -> {
            int a = 0;
            for (long i = 0; i < count; i++) {
                a += 5;
            }
        });

        thread.start();
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        thread.join();
        System.out.println("concurrency:" + time + "ms,b=" + b);
    }

    //单线程
    private static void serial() {
        long start = System.currentTimeMillis();
        int a = 0;
        for (long i = 0; i < count; i++) {
            a += 5;
        }

        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("serial:" + time + "ms,b=" + b + ",a=" + a);
    }
}
