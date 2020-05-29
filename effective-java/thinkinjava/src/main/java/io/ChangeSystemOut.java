package io;

import java.io.PrintWriter;

/**
 * System.out是Java的标准输出流，他是已经包装好的PrintStream对象，默认输出到控制台
 *
 */
public class ChangeSystemOut {
    public static void main(String[] args) {
        try(PrintWriter out = new PrintWriter(System.out,true)){
            out.println("将输出流转到PrintWriter！！！");
        }
    }
}
