package io;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * @author luzj
 * @description: 对MappedByteBuffer进行部分加锁
 * 0 本例启动两个线程（不算主线程），每个线程分别只对文件的一部分加锁，并且进行处理
 * @date 2019/5/5
 */
public class LockingMappedFiles {

    static final int LENGTH = 0x8FFFFFF;//128M
    static FileChannel fc;

    public static void main(String[] args) throws IOException {
        fc = new RandomAccessFile("C:\\sftp_test\\test.dat", "rw").getChannel();
        MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_WRITE, 0, LENGTH);
        for (int i = 0; i < LENGTH; i++) {
            mbb.put((byte) 'x');
        }

        new LockAndModify(mbb,0,0+LENGTH/3);
        new LockAndModify(mbb,LENGTH/2,LENGTH/2+LENGTH/4);
    }

    /**
     * 内部类，继承自Thread
     * 对于被锁定的部分文件进行修改
     */
    private static class LockAndModify extends Thread{
        private ByteBuffer bb;
        private int start,end;

        public LockAndModify(ByteBuffer mbb, int start, int end) {
            this.start = start;
            this.end = end;
            mbb.limit(end);
            mbb.position(start);
            bb = mbb.slice();//切割start到end部分到ByteBuffer
            start();//启动线程
        }

        @Override
        public void run() {
            try {
                FileLock fileLock = fc.tryLock(start,end,false);

                System.out.println("Locked: "+start+" to "+end);
                while (bb.position() < bb.limit()-1)
                    bb.put((byte) (bb.get()+1));

                fileLock.release();
                System.out.println("Released: "+start+" to "+end);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
