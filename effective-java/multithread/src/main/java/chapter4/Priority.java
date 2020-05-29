package chapter4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author luzj
 * @description: 设置优先度来验证高优先是否会被处理器忽略，还是确实有效
 * 0 从打印结果来看，优先度设置被cpu忽略了，1和10差不多
 * @date 2018/10/8
 */
public class Priority {
    public static volatile boolean notStart = true;//volatile确保指令不会被重排，写入即刷进内存，被其他线程看到
    public static volatile boolean notEnd = true;

    public static void main(String[] args) throws InterruptedException {
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int priority = i < 5 ? Thread.MIN_PRIORITY : Thread.MAX_PRIORITY;
            Job job = new Job(priority);
            jobs.add(job);
            Thread thread = new Thread(job);
            thread.setPriority(priority);
            thread.start();
        }

        notStart = false;
        TimeUnit.SECONDS.sleep(10);
        notEnd = false;

        for (Job j : jobs) {
            System.out.println("job priority: " + j.priority + ",count:" + j.jobCount);
        }
    }

    /**
     * 逻辑：
     * 0 notStart = true,开始的会一直在yield()循环
     * 1 notStart = false,之后主线程写入新的值，分线程进入notEnd循环，开始进入自由竞争模式
     * 2 主线程暂停睡眠10s，其他10个线程在此期间不断的 `jobCount++`
     * 3 主线程醒来，notEnd = false,写入新值，volatile保证其他线程立马可见
     * 4 所有的线程运行结束
     * 5 最后打印这10s内，线程的jobCount大小
     */
    static class Job implements Runnable {
        private int priority;
        private long jobCount;

        public Job(int priority) {
            this.priority = priority;
        }

        @Override
        public void run() {
            while (notStart) {
                Thread.yield();
            }

            while (notEnd) {
                Thread.yield();//通过yield让多个线程保持竞争状态，以体现优先度的高竞争能力
                jobCount++;
            }
        }
    }

}
