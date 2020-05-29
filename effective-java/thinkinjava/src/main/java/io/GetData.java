package io;

import java.nio.ByteBuffer;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

/**
 * 关于ByteBuffer的各种asXXXBuffer的用法
 * 可以通过获取ByteBuffer的基本类型视图缓存，来直接put/get基本类型数据
 * 但是他们的底层存储支撑仍然是ByteBuffer
 */
public class GetData {
    static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);

        int i = 0;
        while (i++ < bb.limit())
            if (bb.get() != 0)
                print("nonzero");

        bb.rewind();//重置position位置

        //as char
        bb.asCharBuffer().put("静夜诗");
        char c;
        printnb("char:");
        while ((c = bb.getChar()) != 0)
            printnb(c);
        print();
        bb.rewind();

        //short
        bb.asShortBuffer().put((short) 471142);
        print("short:"+bb.getShort());
        bb.rewind();

        //int
        bb.asIntBuffer().put(99471142);
        print("int:"+bb.getInt());
        bb.rewind();

        //long
        bb.asLongBuffer().put(99471142);
        print("long:"+bb.getLong());
        bb.rewind();

        //float
        bb.asFloatBuffer().put(99471142);
        print("float:"+bb.getFloat());
        bb.rewind();

        //double
        bb.asDoubleBuffer().put(99471142);
        print("double:"+bb.getDouble());
        bb.rewind();

    }
}
