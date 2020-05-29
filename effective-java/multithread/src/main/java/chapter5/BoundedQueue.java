package chapter5;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author luzj
 * @description: 界限队列，由数组实现
 * 0 使用Object[]持有对象，addIndex标识添加下标、removeIndex移除下标、count元素总数
 * 1 使用双Condition
 * 2 当数组满时add，则会导致await，只有等待remove线程调用signal则会唤醒
 * 3 remove方法同上
 * @date 2018/10/16
 */
public class BoundedQueue<T> {
    private Object[] items;
    private int addIndex, removeIndex, count;//添加的下标、移除的下标、元素总数
    private Lock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    public BoundedQueue(int size) {
        this.items = new Object[size];
    }

    public void add(T t) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length)
                notFull.await();
            items[addIndex] = t;
            //数组满了，则addIndex置为0,因为移除是从头部开始的，下次添加也会从头部开始，且addIndex+1
            if (++addIndex == items.length)
                addIndex = 0;
            ++count;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public T remove() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0)
                notEmpty.await();
            Object x = items[removeIndex];
            if (++removeIndex == items.length)//为true时说明数组已经为空了，removeIndex重置为0,且removeIndex+1
                removeIndex = 0;
            --count;
            notFull.signal();
            return (T) x;
        } finally {
            lock.unlock();
        }
    }

}
