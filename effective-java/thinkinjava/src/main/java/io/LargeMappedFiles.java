package io;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

public class LargeMappedFiles {
    static final int length = 0xFFFFFF;

    public static void main(String[] args) throws IOException {
        //从RandomAccessFile获取MappedByteBuffer,MapMode为读写模式
        MappedByteBuffer out = new RandomAccessFile("E:\\txt\\test.dat", "rw").
                getChannel().map(FileChannel.MapMode.READ_WRITE, 0, length);

        //写入byte
        for (int i = 0; i < length; i++) {
            out.put((byte) 'x');
        }
        print("finish write");

        //读取6个byte
        for (int i = length / 2; i < length / 2 + 6; i++) {
            printnb((char) out.get(i));
        }


    }
}
