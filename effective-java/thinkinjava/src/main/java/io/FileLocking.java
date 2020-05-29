package io;

import util.Root;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

/**
 * @author luzj
 * @description: 通过Channel获取文件锁
 * 0 文件锁是调用的系统级的实现，因此对其他进程是可见的
 * 1 通过tryLock(非阻塞)可尝试获取锁，无论成功与否，直接返回
 * 2 通过release释放锁
 * @date 2019/5/5
 */
public class FileLocking {

    public static void main(String[] args) throws IOException, InterruptedException {
        FileOutputStream fos = new FileOutputStream(Root.root+"/public/Index.html");
        //获取文件锁
        FileLock fileLock = fos.getChannel().tryLock();
        if (fileLock != null){
            System.out.println("Locked File");
            TimeUnit.MILLISECONDS.sleep(100);
            //释放锁
            fileLock.release();
            System.out.println("Released Lock");
        }
        fos.close();
    }
}
