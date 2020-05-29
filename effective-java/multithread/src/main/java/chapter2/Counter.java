package chapter2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author luzj
 * @description: cas原子操作 数值累加器
 * @date 2018/10/2
 */
public class Counter {
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    private int i = 0;

    public static void main(String[] args) {
        final Counter cas = new Counter();

        long start = System.currentTimeMillis();
        List<Thread> ts = new ArrayList<>(600);
        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    cas.count();
                    cas.safeCount();
                }
            });
            ts.add(t);
        }

        for (Thread t : ts) {
            t.start();
        }

        for (Thread t : ts) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(cas.i);
        System.out.println(cas.atomicInteger.get());
        System.out.println(System.currentTimeMillis()-start);
    }

    //非原子操作
    private void count(){
        i++;
    }

    //cas 原子操作
    private void safeCount(){
        while (true) {
            int i = atomicInteger.get();
            boolean ok = atomicInteger.compareAndSet(i, ++i);
            if (ok){
                break;
            }
        }
    }

}
