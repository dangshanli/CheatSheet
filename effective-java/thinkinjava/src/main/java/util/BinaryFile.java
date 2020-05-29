package util;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;


public class BinaryFile {
    /**
     * 读取二进制文件成为字节数组
     *
     * @param bFile
     * @return
     */
    public static byte[] read(File bFile) {
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(bFile))) {
            byte[] bytes = new byte[in.available()];
            in.read(bytes);
            return bytes;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static byte[] read(String fileName) {
        return read(new File(fileName).getAbsoluteFile());
    }

    public static void main(String[] args) throws FileNotFoundException {
        String path = "target/classes/practices/thinkinjava/util/Directory.class";
        Map<String, Integer> counter = new HashMap<>();
        byte[] bytes = BinaryFile.read(path);
        for (byte b : bytes) {
            String s = Integer.toHexString(b & 0xFF).toUpperCase();
            if (counter.get(s) == null)
                counter.put(s, 1);
            else
                counter.put(s, counter.get(s) + 1);
        }

        System.out.println(counter);

        //打印.class文件的开头四个字节，为固定"cafebabe"
        System.out.println("=========================");
        List<File> files = Directory.walk("target/classes/practices/thinkinjava/typeinfo").files;
        for (File f : files) {
            print(f.getName() + "\t");
            byte[] bb = BinaryFile.read(f);
//            System.out.println(Byte.toString(bb[0]));
            for (int i = 0; i < 4; i++) {
                printnb(Integer.toHexString(bb[i] & 0xFF).toUpperCase());
            }
            System.out.println();
        }
    }

}
