package io;

import util.Root;

import java.io.*;

/**
 * 可以通过System.setIn/Out/Err几个方法重新定向标准输入、输出、错误流，
 * 下次再调用System.in/out/err的时候，就会返回自定义的那个
 *
 * 需要注意的是，System.in返回时InputStream，因此也必须转到InputStream，不可以转到Reader
 * System.out返回时PrintStream，因此重定向的输出流也需要包装成PrintStream
 */
public class Redirecting {
    public static void main(String[] args) {
        PrintStream console = System.out;//暂存标准输出流
        try(BufferedInputStream in = new BufferedInputStream(new FileInputStream(
                Root.javaRoot+ "/io/Redirecting.java"));
            PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream(
                Root.root+"/public/redirecting.out")));
        ){
            //重定向
            System.setIn(in);
            System.setOut(out);
            System.setErr(out);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s;
            while ((s = br.readLine()) != null){
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.setOut(console);//恢复标准输出流
        }
    }
}
