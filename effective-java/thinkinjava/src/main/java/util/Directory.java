package util;

import net.mindview.util.PPrint;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author luzj
 * @description: 工具类
 * 1 local返回本目录下的文件数组
 * 2 walk返回指定目录下整个目录树的所有文件集合
 * 3 用到File.listFiles 和 String.matches 方法
 * @date 2019/4/28
 */
public final class Directory {

    /**
     * 返回本目录下的全部文件
     *
     * @param dir
     * @param regex
     * @return
     */
    public static File[] local(File dir, final String regex) {
        return dir.listFiles(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);

            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(new File(name).getName()).matches();
            }
        });
    }

    /**
     * local重载
     *
     * @param path
     * @param regex
     * @return
     */
    public static File[] local(String path, final String regex) {
        return local(new File(path), regex);
    }

    /**
     * 内部静态类，收集起点目录树以下的目录集合和文件集合
     */
    public static class TreeInfo implements Iterable<File> {
        public List<File> files = new ArrayList<>();
        public List<File> dirs = new ArrayList<>();

        @Override
        public Iterator<File> iterator() {
            return files.iterator();
        }

        void addAll(TreeInfo treeInfo) {
            files.addAll(treeInfo.files);
            dirs.addAll(treeInfo.dirs);
        }

        @Override
        public String toString() {
            return "dirs: " + PPrint.pformat(dirs) +
                    "\n\nfiles: " + PPrint.pformat(files);
        }
    }
        /**
         * 递归收集
         * @param start
         * @param regex
         * @return
         */
        public static TreeInfo walk(String start, String regex) {
           return recurseDirs(new File(start),regex);
        }

        public static TreeInfo walk(File start,String regex){
            return recurseDirs(start,regex);
        }

        public static TreeInfo walk(File start){
            return recurseDirs(start,".*");
        }

        public static TreeInfo walk(String start){
            return recurseDirs(new File(start),".*");
        }

        /**
         * 收集目录树下的目录集合和文件集合
         * @param startDir
         * @param regex
         * @return
         */
        static TreeInfo recurseDirs(File startDir, String regex) {
            TreeInfo result = new TreeInfo();
            for (File item : startDir.listFiles()) {
                if (item.isDirectory()) {
                    result.dirs.add(item);
                    result.addAll(recurseDirs(item, regex));
                } else {
                    if (item.getName().matches(regex))
                        result.files.add(item);
                }
            }
            return result;
        }


    public static void main(String[] args) {
        File[] f = local(new File("C:\\idea_project\\SpringBootPractice\\EffectiveJava\\" +
                "src\\main\\java\\intro"), ".*\\.java");
        for (File s : f) {
            System.out.println(s.getName());
        }
    }
}
