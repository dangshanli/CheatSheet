package chapter2;

import java.io.*;

/**
 * 可关闭类资源，try-with-resource优于try-finally
 * 使用t-w-r的资源必须实现AutoClose接口
 */
public class TryWithResourceBetter{

    static String firstLineOfLine() throws IOException {
        String path = "E:\\txt\\xxx.txt";
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            return br.readLine();
        }
    }

    static void copy(String src,String dst) throws IOException {
        try(InputStream in = new FileInputStream(src);
        OutputStream out = new FileOutputStream(dst)){
            byte[] buf = new byte[1024];
            int n;
            while ((n = in.read(buf)) >= 0){
                out.write(buf,0,n);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(firstLineOfLine());
        copy("E:\\txt\\xxx.txt","E:\\txt\\yyy.txt");
    }
}
