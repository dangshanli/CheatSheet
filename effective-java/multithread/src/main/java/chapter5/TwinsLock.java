package chapter5;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author luzj
 * @description: 使用抽象队列同步器实现一个TwinsLock锁，一次允许线程同时获得锁
 * 0 这是一个共享锁
 * 1 组合{@code AbstractQueuedSynchronizer}的实现类
 * 2 自定义实现{@code tryAcquireShared(int arg)}和{@code tryReleaseShared(int arg)}
 * @date 2018/10/15
 */
public class TwinsLock implements Lock {
    private final Sync sync = new Sync(2);

    private static final class Sync extends AbstractQueuedSynchronizer {
        Sync(int count) {
            if (count < 0)
                throw new IllegalArgumentException("count 必须大于0");
            setState(count);
        }

        @Override
        public int tryAcquireShared(int arg) {
            for (; ; ) {
                int current = getState();
                int newCount = current - arg;
                if (newCount < 0 || compareAndSetState(current, newCount))
                    return newCount;
            }
        }

        @Override
        public boolean tryReleaseShared(int arg) {
            for (; ; ) {
                int current = getState();
                int newCount = current + arg;
                if (compareAndSetState(current, newCount))
                    return true;
            }
        }
    }

    @Override
    public void lock() {
        sync.acquireShared(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        sync.releaseShared(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
