package io;

import util.Root;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * 专注于文本的读写，这涉及到字符编码处理的问题
 */
public class BufferToText {
    private static final int BSIZE = 1024;

    //不做任何编码，只是读取。或者对读取的缓存进行decoding
    public static void notEncodingText() {
        String path = Root.root+ "/public/io/no_encoding.txt";

        try (FileChannel in = new FileInputStream(path).getChannel();
             FileChannel out = new FileOutputStream(path).getChannel()) {

            out.write(ByteBuffer.wrap("How to combat the threat of Android malware.卧槽".getBytes()));
            ByteBuffer bb = ByteBuffer.allocate(BSIZE);
            in.read(bb);
            bb.flip();
            System.out.println(bb.asCharBuffer());

            bb.rewind();
            String encoding = System.getProperty("file.encoding");
            System.out.println("使用编码为：" + encoding + "," +
                    Charset.forName(encoding).decode(bb));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //对输入使用指定编码
    public static void usingUTF16(){
        String file = Root.root+"/public/io/utf16.txt";
        try(FileChannel in = new FileInputStream(file).getChannel();
        FileChannel out = new FileOutputStream(file).getChannel()){

            out.write(ByteBuffer.wrap("床前明月光，疑是地上霜。".getBytes("UTF-16BE")));
            ByteBuffer bb = ByteBuffer.allocate(BSIZE);
            in.read(bb);
            bb.flip();
            System.out.println(bb.asCharBuffer());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //直接使用CharBuffer进行读写，不做显示编码动作
    public static void charBufferRW(){
        String file = Root.root+"/public/io/charBuffer.txt";
        try(FileChannel in = new FileInputStream(file).getChannel();
            FileChannel out = new FileOutputStream(file).getChannel()){

            ByteBuffer buffer = ByteBuffer.allocate(24);
            buffer.asCharBuffer().put("举头望明月，低头思故乡。");
            out.write(buffer);

            buffer.clear();
            in.read(buffer);
            buffer.flip();
            System.out.println(buffer.asCharBuffer());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        notEncodingText();
        usingUTF16();
        charBufferRW();
    }

}
