package chapter6;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @author: luzj
 * @date: 2019-01-23
 * @description: 使用Fork-Join 计算 (a+(a+1)+(a+2)+...+(a+n))=?
 * 0 首选要定义好Task
 * 1 实现compute()方法，定义分裂的阈值，并在其中进行合并结果
 * 2 最后将Task提交(submit)给F-J框架即可
 * 3 一定要要记住子任务之间没有互相依赖，必须是可独立计算的，结果也是可以合并的
 * 4 当然从框架给出的类和API来看，不止这一点可以用，更多的用法还待探索
 */
public class CountTask extends RecursiveTask<Integer> {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask countTask = new CountTask(1, 100);
        Future<Integer> result = forkJoinPool.submit(countTask);

        try {
            int a = result.get();
            System.out.println("1+2+3...+100 = " + a);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static final int THRESHOLD = 10;//分割阈值
    private int start;
    private int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    /**
     * 重点在于实现compute方法，规定计算方式
     * @return
     */
    @Override
    protected Integer compute() {
        int sum = 0;

        boolean canCompute = (end - start) <= THRESHOLD;
        //计算数低于阈值则直接计算，否则进行fork()
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            int mid = (start + end) / 2;
            //将当前任务分裂成两个CountTask分别计算
            //这是一个递归调用，因此如果子Task还不满足阈值要求，则继续分裂
            CountTask left = new CountTask(start, mid);
            CountTask right = new CountTask(mid + 1, end);
            //执行子任务
            left.fork();
            right.fork();
            //获取结果
            int leftResult = left.join();
            int rightResult = right.join();
            //合并结果。可以看到，分割任务、合并结果都依赖我们手动划分，f-j框架只负责多线程的调度
            sum = leftResult + rightResult;
        }
        return sum;
    }
}
