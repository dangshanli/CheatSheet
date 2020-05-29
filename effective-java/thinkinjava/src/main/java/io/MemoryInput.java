package io;

import java.io.IOException;
import java.io.StringReader;

/**
 * @author luzj
 * @description: StringReader更像是实现了Reader接口的字符串容器，即带有IO继承的字符串
 * @date 2019/4/30
 */
public class MemoryInput {
    public static void main(String[] args) throws IOException {
        String path = MemoryInput.class.getClassLoader().
                getResource("public/Index.html").getPath();
        StringReader in = new StringReader(BufferedInputFile.read(path));
        int c;
        while ((c = in.read()) != -1) {
            System.out.print((char) c);
        }
    }
}
