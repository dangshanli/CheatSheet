package io;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * clear()：position limit全部重置
 * flip():position置为0，limit转position，主要是给while读取buffer之前做好准备
 * rewind():只是把position置为0，limit不管，主要是给读了一遍的buffer再一次读取的机会
 */
public class IntBufferDemo {
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(1024);
        IntBuffer ib = bb.asIntBuffer();

        ib.put(new int[]{12, 33, 55, 789, 4587, 663});
        printIntBufferPosition(ib);
        System.out.println("position 3 value:"+ib.get(3));
        ib.put(3,1811);
        ib.flip();
        while (ib.hasRemaining()){
            int i = ib.get();
            System.out.println(i);
        }
        printIntBufferPosition(ib);

    }

    static void printIntBufferPosition(IntBuffer ib) {
        System.out.println("position:" + ib.position());
        System.out.println("mark:" + ib.mark());
        System.out.println("limit:" + ib.limit());
        System.out.println("capacity:" + ib.capacity());
        System.out.println("--------------------");
    }
}
