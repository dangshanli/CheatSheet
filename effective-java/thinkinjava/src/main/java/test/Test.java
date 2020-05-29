package test;

import util.Root;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @author luzj
 * @description:
 * @date 2019/4/29
 */
public class Test {

    public static void main(String[] args) throws IOException {
        String  path = Root.root+ "/public";
        Path d = Paths.get(path);
        Files.walkFileTree(d, new FileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                System.out.println("-----我将要遍历这个目录了-----："+dir);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println("当前便利到文件:"+file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                System.out.println("我好想出了点状况"+file);
                System.err.println(exc);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                System.out.println("-----我遍历完了目录-----:"+dir);
                return FileVisitResult.CONTINUE;
            }
        });

    }
}