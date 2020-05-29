package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author luzj
 * @description: 0 遍历目录下的文件
 * 1 主要使用File.list()
 * 1 Pattern.compile(regex).matches();
 * @date 2019/4/28
 */
public class DirList2 {

    //使用方法返回匿名内部类
    public static FilenameFilter filter(final String regex){
        return new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        };
    }

    public static void main(String[] args) {
        File file = new File("C:\\idea_project\\SpringBootPractice\\EffectiveJava\\" +
                "src\\main\\java\\practices\\thinkinjava\\typeinfo\\proxy");
        String[] list;
        String regex = ".*[i].*\\.java";//任何带i的.java文件
        list = file.list(filter(regex));
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        for (String item:list) {
            System.out.println(item);
        }
    }
}
