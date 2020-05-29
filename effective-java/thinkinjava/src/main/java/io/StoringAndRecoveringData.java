package io;

import java.io.*;

/**
 * @author luzj
 * @description: 使用DataOutputStream写入文件，DataInputStream读取文件
 * 1 这里一个限制是，读取的时候必须知道当时写入的顺序，且要一一对应
 * @date 2019/4/30
 */
public class StoringAndRecoveringData {
    public static void main(String[] args) throws IOException {
        String path = StoringAndRecoveringData.class.getClassLoader().
                getResource("public/store_revover.txt").getPath();

        try (DataOutputStream out = new DataOutputStream(new BufferedOutputStream(
                new FileOutputStream(path)));
        ) {
            //写
            out.writeDouble(3.14159);
            out.writeUTF("这是pi");
            out.writeDouble(1.1414133);
            out.writeUTF("2的平方根");
        }

        try (DataInputStream in = new DataInputStream(new BufferedInputStream(
                new FileInputStream(path)))) {
            //读
            System.out.println(in.readDouble());
            System.out.println(in.readUTF());
            System.out.println(in.readDouble());
            System.out.println(in.readUTF());
        }


    }
}
