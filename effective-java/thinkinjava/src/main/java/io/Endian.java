package io;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

import static net.mindview.util.Print.print;

public class Endian {
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[12]);
        bb.asCharBuffer().put("abcdef");
        print(Arrays.toString(bb.array()));//默认大端排列
        bb.rewind();
        bb.order(ByteOrder.LITTLE_ENDIAN);//置为小端排列

        bb.asCharBuffer().put("abcdef");
        print(Arrays.toString(bb.array()));



    }
}
