package io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

import static net.mindview.util.Print.print;

/**
 * 交换相邻字符
 * mark:标记当前position
 * reset：将position转为mark的位置
 */
public class UsingBuffers {

    /**
     * 交换相邻字符
     *
     * @param buffer
     */
    static void symmetricScramble(CharBuffer buffer) {
        buffer.mark();
        char c1 = buffer.get();
        char c2 = buffer.get();
        buffer.reset();
        buffer.put(c2).put(c1);
    }

    public static void main(String[] args) {
        char[] data = "UsingBuffers".toCharArray();
        ByteBuffer bb = ByteBuffer.allocate(data.length * 2);
        CharBuffer cb = bb.asCharBuffer();
        cb.put(data);
        print(cb.rewind());
        symmetricScramble(cb);
        print(cb.rewind());
        symmetricScramble(cb);
        print(cb.rewind());
    }
}
