package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * System.in是Java的标准输入流，是一个未包装InputStream
 * 默认标准输入流就是控制台输入
 */
public class Echo {

    public static void main(String[] args) {
        //从标准输入读取信息，并且包装成BufferedReader,
        // System.in是一个InputStream，未经过包装
        try(BufferedReader in = new BufferedReader(new InputStreamReader(System.in))){
            String s;
            while ((s = in.readLine()) != null && s.length() > 0){
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
