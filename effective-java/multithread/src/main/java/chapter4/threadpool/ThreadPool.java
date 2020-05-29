package chapter4.threadpool;

/**
 * @author luzj
 * @description:
 * @date 2018/10/10
 */
public interface ThreadPool<Job extends Runnable> {
    void execute(Job job);//执行一个新的task
    void shutdown();//关闭线程池,使不在执行任务
    void addWorkers(int num);//添加工作线程
    void removeWorker(int num);//移除工作线程
    int getJobSize();//获取当前还剩的任务数量
}
