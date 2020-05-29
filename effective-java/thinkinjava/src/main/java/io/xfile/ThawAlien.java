package io.xfile;

import java.io.*;

/**
 * 反序列化对象的时候，本地虚拟机也需要能够找到对应的Class对象，即能够检索到.class文件
 * 如果没有则会爆出ClassNotFoundException，反序列化失败
 * 因此，可以猜测，序列化的文件时保存的对象内信息，而不是整个.class文件和对象状态信息，因此本地虚拟机必须加载相应的Class对象才可以
 */
public class ThawAlien {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(
                new File("src/main/resources/public/X.file")));
        Object mystery = in.readObject();
        System.out.println(mystery.getClass());
    }
}
