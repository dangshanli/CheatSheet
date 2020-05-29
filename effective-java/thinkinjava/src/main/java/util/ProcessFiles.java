package util;

import java.io.File;
import java.io.IOException;

/**
 * @author luzj
 * @description: 策略模式处理文件
 * @date 2019/4/28
 */
public class ProcessFiles {
    /**
     * 内部策略接口
     */
    public interface Strategy {
        void process(File file);
    }

    private Strategy strategy;//处理策略
    private String ext;//文件后缀

    public ProcessFiles(Strategy strategy, String ext) {
        this.strategy = strategy;
        this.ext = ext;
    }

    /**
     * 遍历当前目录树或者指定目录树，并且一一处理
     * @param args
     */
    public void start(String[] args) {
        if (args.length == 0)
            processDirectory(new File("."));
        else {
            for (String arg : args) {
                File f = new File(arg);
                if (f.isDirectory())
                    processDirectory(f);
                else {
                    if (!arg.endsWith(".ext"))
                        arg += ".ext";
                    try {
                        strategy.process(new File(arg).getCanonicalFile());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }


    /**
     * 通过初始化的Strategy处理文件
     * @param root
     */
    public void processDirectory(File root) {
        for (File f : Directory.walk(root.getAbsolutePath(), ".*\\." + ext)) {
            strategy.process(f);
        }
    }

    public static void main(String[] args) {
        new ProcessFiles(new Strategy() {
            @Override
            public void process(File file) {
                System.out.println(file);
            }
        }, "java").start(args);
    }
}
