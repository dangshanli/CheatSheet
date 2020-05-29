package chapter5;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author luzj
 * @description: 使用读写锁实现一个线程安全的HashMap
 * @date 2018/10/15
 */
public class Cache {
    static Map<String, Object> map = new HashMap<>();
    static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    static Lock read = rwl.readLock();
    static Lock write = rwl.writeLock();

    public static final Object get(String key) {
        read.lock();
        try {
            return map.get(key);
        } finally {
            read.unlock();
        }
    }

    public static final Object put(String key, Object obj) {
        write.lock();
        try {
            return map.put(key, obj);
        } finally {
            write.unlock();
        }
    }

    public static final void clear() {
        write.lock();
        try {
            map.clear();
        } finally {
            write.unlock();
        }
    }


}
