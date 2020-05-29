package util;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * 一个读写文本文件的公共工具
 */
public class TextFile extends ArrayList<String> {
    /**
     * 读取文件，赋值字符串
     *
     * @param fileName 读取文件
     * @return
     */
    public static String read(String fileName) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(
                new File(fileName).getAbsoluteFile()));) {
            String s;
            while ((s = in.readLine()) != null) {
                sb.append(s + "\n");
            }
        }
        return sb.toString();
    }

    /**
     * 将text写入filename里面
     *
     * @param fileName
     * @param text
     * @throws FileNotFoundException
     */
    public static void write(String fileName, String text) throws FileNotFoundException {
        try (PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());) {
            out.print(text);
        }
    }

    public TextFile(String fileName,String splitter) throws IOException {
        super(Arrays.asList(read(fileName).split(splitter)));
        if (get(0).equals(""))
            remove(0);
    }

    public TextFile(String fileName) throws IOException {
        this(fileName,"\n");
    }

    /**
     * 将List里面的String读进文件
     *
     * @param fileName
     * @throws FileNotFoundException
     */
    public void write(String fileName) throws FileNotFoundException {
        try (PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());) {
            for (String item : this) {
                out.println(item);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String path = Root.javaRoot+ "/io/TextFile.java";
        String path1 = Root.root+"/public/textFile.txt";
        String path2 = Root.root+"/public/textFile2.txt";

        String file = read(path);
        write(path1,file);
        TextFile text = new TextFile(path1);
        text.write(path2);

        TreeSet<String> words = new TreeSet<>(new TextFile(path,"\\W+"));
        System.out.println(words.headSet("a"));
    }


}
