package io;

import java.io.*;

/**
 * @author luzj
 * @description: 使用PrintWrite(new BufferedWrite ( new FileWrite ( path))) 输出文件
 * 直接PrintWriter()也是可以的，仍然具有缓冲能力，相当于Java内置的快捷方式
 * @date 2019/4/30
 */
public class BasicFileOutput {
    static String path = BasicFileOutput.class.getClassLoader().getResource("public/绝句.txt").getPath();

    public static void main(String[] args) throws IOException {
        String content = "千山鸟飞绝\n"
                + "万径人踪灭\n"
                + "孤舟蓑笠翁\n"
                + "独钓寒江雪\n";

        try (BufferedReader in = new BufferedReader(new StringReader(content));
//             PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path)))
             PrintWriter out = new PrintWriter(path);//一种快捷方式，不需要层层包装，已内置实现
        ) {
            int lineCount = 1;
            String s;
            while ((s = in.readLine()) != null) {
                out.println(lineCount++ + ":" + s);
            }
        }
        System.out.println(BufferedInputFile.read(path));
    }
}
