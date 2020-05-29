package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author luzj
 * @description: 使用 BufferedReader(new FileReader(path))读取文本文件
 * @date 2019/4/30
 */
public class BufferedInputFile {

    public static String read(String path) throws IOException {
        //使用try-with-resource
        try(BufferedReader in = new BufferedReader(new FileReader(path))){
            String s;
            StringBuilder sb = new StringBuilder();
            while ((s = in.readLine()) != null){
                sb.append(s+"\n");
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) throws IOException {
        //读取工程内相对路径文件
        String path = BufferedInputFile.class.getClassLoader().
                getResource("public/newspaper.txt").getPath();
        System.out.println(read(path));

    }


}
