package com.jenkov.nioserver;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by jjenkov on 16-10-2015.
 * 用于处理SocketChannel读写的工具类
 */
public class Socket {

    public long socketId;

    public SocketChannel  socketChannel = null;
    public IMessageReader messageReader = null;
    public MessageWriter  messageWriter = null;

    public boolean endOfStreamReached = false;

    public Socket() {
    }

    /**
     *SocketChannel由外部注入
     */
    public Socket(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    /**
     * 将读取SocketChannel的信息到ByteBuffer
     * @param byteBuffer
     * @return 读取的总byte数
     * @throws IOException
     */
    public int read(ByteBuffer byteBuffer) throws IOException {
        int bytesRead = this.socketChannel.read(byteBuffer);
        int totalBytesRead = bytesRead;

        while(bytesRead > 0){
            bytesRead = this.socketChannel.read(byteBuffer);
            totalBytesRead += bytesRead;
        }
        if(bytesRead == -1){
            this.endOfStreamReached = true;
        }

        return totalBytesRead;
    }

    /**
     * 将ByeBuffer的信息写入SocketChannel
     * @param byteBuffer
     * @return 写入总byte数
     * @throws IOException
     */
    public int write(ByteBuffer byteBuffer) throws IOException{
        int bytesWritten      = this.socketChannel.write(byteBuffer);
        int totalBytesWritten = bytesWritten;

        while(bytesWritten > 0 && byteBuffer.hasRemaining()){
            bytesWritten = this.socketChannel.write(byteBuffer);
            totalBytesWritten += bytesWritten;
        }

        return totalBytesWritten;
    }


}
