package multi_chapter5;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author luzj
 * @description: 公平锁与非公平锁测试
 * 0 公平锁保证线程在队列里按照FIFO原则获取锁
 * 1 非公平锁则是按照效率最佳原则，一般而言如果一个线程获取锁，则再次获取锁的几率极大
 * 2 重更大范围的测试来看，公平锁由于FIFO原则限制，导致大量切换线程，而非公平锁则切换较少，两者可能相差几十倍
 * 3 非公平锁可能造成"饥饿"情况，即一个线程一直获取不到执行权，但是保证了更大的吞吐量
 * 4 非公平锁也是默认的ReentrantLock实现
 * @date 2018/10/15
 */
public class FairAndUnfairTest {
    private static Lock fair = new ReentrantLock2(true);//公平锁
    private static Lock unfair = new ReentrantLock2(false);//非公平锁

    @Test
    public void fairT() {
        testLock(fair);
    }

    @Test
    public void unfairT() {
        testLock(unfair);
    }

    private void testLock(Lock lock) {
        for (int i = 0; i < 5; i++) {
            Job job = new Job(lock);
            job.setDaemon(true);
            job.start();
        }
    }


    //线程定义
    private static class Job extends Thread {
        private Lock lock;

        public Job(Lock lock) {
            this.lock = lock;
        }

        //两次打印信息，打印一次就释放锁，重新参与竞争
        @Override
        public void run() {
            for (int i = 0; i < 2; i++) {
                lock.lock();
                try {
                    System.out.println("current thread:" + Thread.currentThread().getName());
                    System.out.println("等待队列列表：");
                    if (lock instanceof ReentrantLock2) {
                        for (Thread t : ((ReentrantLock2) lock).getQueuedThreads()) {
                            System.out.print(t.getName() + "\t");
                        }
                    } else {
                        System.out.println("一首凉凉");
                    }
                    System.out.println();
                    System.out.println();
                } finally {
                    lock.unlock();
                }
            }
        }
    }


    //重写getQueuedThreads，反转Thread序列
    private static class ReentrantLock2 extends ReentrantLock {
        public ReentrantLock2(boolean fair) {
            super(fair);
        }

        @Override
        public Collection<Thread> getQueuedThreads() {
            List<Thread> arrayList = new ArrayList<>(super.getQueuedThreads());
            Collections.reverse(arrayList);
            return arrayList;
        }
    }
}
