package io;

import java.io.*;

/**
 * @author luzj
 * @description: 使用DataInputStream.available()测试文件EOF
 * @date 2019/4/30
 */
public class TestEOF {
    public static void main(String[] args) throws IOException {
        String path = TestEOF.class.getClassLoader().
                getResource("public/Index.html").getPath();

        try (DataInputStream in = new DataInputStream(new BufferedInputStream(
                new FileInputStream(path)))) {
            while (in.available() > 0) {
                System.out.print((char) in.readByte());
            }
        }

    }
}
