package chapter4.threadpool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author luzj
 * @description: 一个默认线程池实现
 * 0 我觉的不是一定要拿jobs作为锁，但是作为锁也没有什么问题，总是需要一个锁不是么
 * 1 一个线程池有：执行新任务、伸缩池容量、获取任务解决进度、关闭池这几个功能
 * @date 2018/10/10
 */
public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job> {
    private static final int MAX_WORKER_NUMBERS = 10;//最大工作线程数
    public static final int DEFAULT_WORKER_NUMBERS = 5;//默认线程
    public static final int MIN_WORKER_NUMBERS = 1;//最小线程

    private final LinkedList<Job> jobs = new LinkedList<>();//持有任务的链表
    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());//持有工作线程链表
    private int workerNum = DEFAULT_WORKER_NUMBERS;
    private AtomicLong threadNum = new AtomicLong();//线程编号

    public DefaultThreadPool() {
        initWorkers(DEFAULT_WORKER_NUMBERS);
    }

    public DefaultThreadPool(int num) {
        if (num > MAX_WORKER_NUMBERS)
            this.workerNum = MAX_WORKER_NUMBERS;
        else
            this.workerNum = num < MIN_WORKER_NUMBERS ? MIN_WORKER_NUMBERS : num;
        initWorkers(workerNum);
    }

    /**
     * 0 添加新任务，唤醒一个线程，来消费该任务
     * 1 如果Worker线程都很忙，就会积压在链表中，等待空余的线程检查链表是否为空，主动消费
     * @param job
     */
    @Override
    public void execute(Job job) {
        if (job != null)
            synchronized (jobs) {
                jobs.addLast(job);
                jobs.notify();
            }
    }

    @Override
    public void shutdown() {
        for (Worker w : workers) {
            w.shutdown();
        }
    }

    @Override
    public void addWorkers(int num) {
        synchronized (jobs) {
            if (num + this.workerNum > MAX_WORKER_NUMBERS)
                num = MAX_WORKER_NUMBERS - this.workerNum;
            initWorkers(num);
            this.workerNum += num;
        }
    }

    @Override
    public void removeWorker(int num) {
        synchronized (jobs) {
            if (num >= this.workerNum)
                throw new IllegalArgumentException("超出worker num");

            int count = 0;
            while (count < num) {
                Worker worker = workers.get(count);
                if (workers.remove(worker)) {
                    worker.shutdown();
                    count++;
                }
            }
            this.workerNum -= num;
        }
    }

    @Override
    public int getJobSize() {
        return jobs.size();
    }

    private void initWorkers(int num) {
        for (int i = 0; i < num; i++) {
            Worker worker = new Worker();
            workers.add(worker);
            Thread thread = new Thread(worker, "threadPool-Worker-" + threadNum.incrementAndGet());
            thread.start();
        }
    }

    /**
     * 工作线程
     * 0 一次执行一个任务
     * 1 当任务链表为空的时候进入等待
     * 2 线程池添加新job的时候，会被notify，并消费该任务
     */
    class Worker implements Runnable {
        private volatile boolean running = true;

        @Override
        public void run() {
            while (running) {
                Job job = null;
                synchronized (jobs) {
                    while (jobs.isEmpty()) {
                        try {
                            jobs.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    job = jobs.removeFirst();
                }

                if (job != null) {
                    try {
                        job.run();
                    } catch (Exception e) {
                    }
                }
            }
        }

        public void shutdown() {
            running = false;
        }
    }


}
