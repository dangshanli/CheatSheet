package chapter4;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @author luzj
 * @description: 打印当前程序的所有线程信息
 * 0 在java中，即使最简单的程序，也会伴随着多个线程工作
 * @date 2018/10/8
 */
public class MultiThread {
    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo info : threadInfos) {
            System.out.println("["+info.getThreadId()+"]"+info.getThreadName());
        }
    }
}
