package io;

import util.Root;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelCopy {
    private static final int BSIZE = 1024;

    public static void copy(String from, String to) {
        try (FileChannel in = new FileInputStream(from).getChannel();
             FileChannel out = new FileOutputStream(to).getChannel()) {
            ByteBuffer bf = ByteBuffer.allocate(BSIZE);
            while (in.read(bf) != -1){
                bf.flip();
                out.write(bf);
                //清理ByteBuffer用于再次读取
                bf.clear();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        copy(Root.root+"/public/getChannel.txt",Root.root+"/public/copyChannel.txt");
    }
}
