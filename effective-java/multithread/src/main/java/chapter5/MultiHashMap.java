package chapter5;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author luzj
 * @description: hashmap 非线程安全，在并发环境下put容易死循环
 * 0 hashMap如果需要扩容resize的时候，此时进行rehash，重新排布各个Entry节点
 * 1 在多线程环境下，由于线程之间的操作不可见，导致节点链表形成环状
 * 2 最终在读取的时候形成死循环
 * 3 ConcurrentHashMap是一个线程安全的HashMap，不会在并发环境下产生以下问题，因此在并发环境中使用Map容器需要使用ConcurrentHashMap
 * 4 ConcurrentHashMap在
 * @date 2018/10/17
 */
public class MultiHashMap {
    final static Map<String, String> map = new HashMap<>(10);

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                new Thread(() -> {
                    map.put(UUID.randomUUID().toString(), "233");
                }, "ftf" + i).start();
            }
        }, "ftf");
        t.start();
        t.join();
        for (Map.Entry<String, String> e : map.entrySet()) {
            System.out.println(e.getKey()+"->"+e.getValue());
        }

    }
}
