package io;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

/**
 * @author luzj
 * @description: 使用DataInputStream(new ByteArrayInput(InputStream))读取文件
 * @date 2019/4/30
 */
public class FormattedMemoryInput {

    public static void main(String[] args) throws IOException {
        String path = FormattedMemoryInput.class.getClassLoader().
                getResource("public/Index.html").getPath();

        try (DataInputStream in = new DataInputStream(
                new ByteArrayInputStream(BufferedInputFile.read(path).getBytes("UTF8")))) {
            while (true) {//如果返回是字节，返回值不可用来检测是否结束，只能坐等EOF异常
                System.out.print((char) in.readByte());
            }
        } catch (EOFException e) {
            System.err.println("end of stream!!!");
        }
    }
}
