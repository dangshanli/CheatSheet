package chapter4;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @author luzj
 * @description: piped可以用来辅助线程之间通信
 * @date 2018/10/9
 */
public class Piped {
    public static void main(String[] args) throws IOException {
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();
        out.connect(in);//输出、输入管道连接
        Thread printThread = new Thread(new Print(in), "print_Thread");//print线程持有输入管道
        printThread.start();

        //主线程向输出管道写入字符
        int receive = 0;
        try {
            while ((receive = System.in.read()) != -1) {
                out.write(receive);//输出写入，输入即可读取
            }
        } finally {
            out.close();
        }
    }


    static class Print implements Runnable {
        private PipedReader in;

        public Print(PipedReader in) {
            this.in = in;
        }

        @Override
        public void run() {
            int receive = 0;
            try {
                while (-1 != (receive = in.read())) {
                    System.out.print((char) receive);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
