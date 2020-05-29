package io;

import java.io.*;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 你叫一般IO和映射文件访问的速度差距
 */
public class MappedIO {
    static final int numOfInts = 4000 * 1000;
    static final int numOfUbuffInts = 200 * 1000;

    /**
     * 私有抽象类，定义模板方法，用于测量IO的时间
     */
    private abstract static class Tester {
        private String name;

        public Tester(String name) {
            this.name = name;
        }

        void runTester() {
            System.out.print(name + ": ");
            try {
                long start = System.nanoTime();
                test();
                double duration = System.nanoTime() - start;
                System.out.format("%.2f\n", duration / 1.0e9);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public abstract void test() throws IOException;
    }

    static String path = "E:\\txt\\temp.dat";
    private static Tester[] tests = {
            new Tester("Stream Write") {
                @Override
                public void test() throws IOException {
                    try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(
                            new FileOutputStream(path)));) {
                        for (int i = 0; i < numOfInts; i++) {
                            dos.writeInt(i);
                        }
                    }
                }
            },
            new Tester("Mapped Write") {
                @Override
                public void test() throws IOException {
                    try (FileChannel out = new RandomAccessFile(path, "rw").getChannel();) {
                        MappedByteBuffer mbb = out.map(FileChannel.MapMode.READ_WRITE, 0, out.size());
                        IntBuffer ib = mbb.asIntBuffer();
                        for (int i = 0; i < numOfInts; i++) {
                            ib.put(i);
                        }
                    }
                }
            },
            new Tester("Stream Read") {
                @Override
                public void test() throws IOException {
                    try (DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(path)))) {
                        for (int i = 0; i < numOfInts; i++) {
                            in.readInt();
                        }
                    }
                }
            },
            new Tester("Mapped Read") {
                @Override
                public void test() throws IOException {
                    try (FileChannel fc = new FileInputStream(path).getChannel()) {
                        MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
                        IntBuffer ib = mbb.asIntBuffer();
                        while (ib.hasRemaining())
                            ib.get();
                    }
                }
            },
            new Tester("Stream RW") {
                @Override
                public void test() throws IOException {
                    try (RandomAccessFile raf = new RandomAccessFile(new File(path), "rw");) {
                        raf.writeInt(1);
                        for (int i = 0; i < numOfUbuffInts; i++) {
                            raf.seek(raf.length() - 4);
                            raf.writeInt(raf.readInt());
                        }
                    }
                }
            },
            new Tester("Mapped RW") {
                @Override
                public void test() throws IOException {
                    try (FileChannel fc = new RandomAccessFile(new File(path), "rw").getChannel()) {
                        IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size()).asIntBuffer();
                        ib.put(0);
                        for (int i = 1; i < numOfUbuffInts; i++) {
                            ib.put(ib.get(i - 1));
                        }
                    }
                }
            }
    };

    public static void main(String[] args) {
        for (Tester t : tests) {
            t.runTester();
        }
    }
}
