package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * @author luzj
 * @description:
 * @date 2019/5/15
 */
public class Test2 {
    public static void main(String[] args) throws IOException {
        String path = "C:\\sftp_test\\GoEdit.txt";
        String path2 = "C:\\sftp_test\\GoEdit1.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path));
             PrintWriter pw = new PrintWriter(path2)) {
            String s;
            int count = 1;
            while ((s = br.readLine()) != null && !s.equals("")) {
                pw.println((count++) + ". " + s);
            }
        }
    }
}
