package io;

import util.Root;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * 调用in.transferTo(out)直接拷贝数据
 */
public class TransferTo {

    public static void transfer(String from, String to) {
        try (FileChannel in = new FileInputStream(from).getChannel();
             FileChannel out = new FileOutputStream(to).getChannel()) {

            in.transferTo(0, in.size(), out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        transfer(Root.root+"/public/getChannel.txt",Root.root+"/public/copyChannel.txt");
    }
}
