package io;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author luzj
 * @description: 使用RandomAccessFile进行读写
 * RandomAccessFile不在Stream继承体系之中，他是单独的一个
 * @date 2019/4/30
 */
public class UsingRandomAccessFile {
    static void display(String file) throws IOException {
        try (RandomAccessFile rf = new RandomAccessFile(file, "r");) {
            for (int i = 0; i < 7; i++) {
                System.out.println("Value " + i + ": " + rf.readDouble());
            }
            System.out.println(rf.readUTF());
        }
    }

    public static void main(String[] args) throws IOException {
        String file = UsingRandomAccessFile.class.getClassLoader().
                getResource("public/raf.dat").getPath();
        try (RandomAccessFile rf = new RandomAccessFile(file, "rw")) {
            for (int i = 0; i < 7; i++) {
                rf.writeDouble(i * 1.414);
            }
            rf.writeUTF("文件结束");

            display(file);

            rf.seek(5 * 8);//移动读写指针到指定位置，一个double 8 byte，5*8即在第6个位置开头
            rf.writeDouble(47.0001);
        }
        display(file);
    }

}
