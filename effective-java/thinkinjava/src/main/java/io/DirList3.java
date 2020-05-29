package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author luzj
 * @description: 0 匿名内部类
 * 1 内部类直接写在参数位
 * @date 2019/4/28
 */
public class DirList3 {
    public static void main(String[] args) {
        String path = "C:\\idea_project\\SpringBootPractice\\EffectiveJava\\" +
                "src\\main\\java\\practices\\thinkinjava\\typeinfo\\proxy";
        File file = new File(path);
        final String regex = ".*i.*\\.java";
        String[] list = file.list(new FilenameFilter() {
            Pattern pattern = Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        });
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        for (String l:list) {
            System.out.println(l);
        }
    }

}
