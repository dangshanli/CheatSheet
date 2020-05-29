package io;

import util.Root;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * FileChannel可以通过InputStream OutputStream RandomAccessFile 的getChannel方法获得
 * Channel只和ByteBuffer交互，ByteBuffer是待传递信息的载体
 * FileChannel可以write 或者 read ByteBuffer
 */
public class GetChannel {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws IOException {
        String path = Root.root + "/public/getChannel.txt";

        //write info to fc
        FileChannel fc = new FileOutputStream(path).getChannel();
        fc.write(ByteBuffer.wrap("一些信息。".getBytes("UTF-16")));
        fc.close();

        fc = new RandomAccessFile(path,"rw").getChannel();
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap("多得多的信息！".getBytes("UTF-16")));
        fc.close();

        //get info from fc
        fc = new FileInputStream(path).getChannel();
        ByteBuffer bf = ByteBuffer.allocate(BSIZE);
        fc.read(bf);
        //flip将 limit置为position，将position置为0，接下来冲ByteBuffer执行get操作的时候就可以从0读到position的位置了
        bf.flip();
        System.out.println(bf.asCharBuffer());

        fc.close();

        System.out.println();
        System.out.println(Charset.availableCharsets());
    }
}
