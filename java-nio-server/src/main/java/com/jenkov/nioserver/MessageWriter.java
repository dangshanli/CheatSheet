package com.jenkov.nioserver;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jjenkov on 21-10-2015.
 */
public class MessageWriter {

    private List<Message> writeQueue   = new ArrayList<>();
    private Message  messageInProgress = null;
    private int      bytesWritten      =    0;

    public MessageWriter() {
    }

    /**
     * 消息入链表，初次则存入messageInProgress中
     * @param message
     */
    public void enqueue(Message message) {
        if(this.messageInProgress == null){
            this.messageInProgress = message;
        } else {
            this.writeQueue.add(message);
        }
    }

    /**
     * 处理Message链表，写入socketChannel
     * @param socket
     * @param byteBuffer
     * @throws IOException
     */
    public void write(Socket socket, ByteBuffer byteBuffer) throws IOException {
        //将Message写入ByteBuffer
        byteBuffer.put(this.messageInProgress.sharedArray,
                this.messageInProgress.offset + this.bytesWritten,
                this.messageInProgress.length - this.bytesWritten);
        byteBuffer.flip();

        //将byteBuffer写入SocketChannel
        this.bytesWritten += socket.write(byteBuffer);
        byteBuffer.clear();

        if(bytesWritten >= this.messageInProgress.length){
            //继续从链表中取Message
            if(this.writeQueue.size() > 0){
                this.messageInProgress = this.writeQueue.remove(0);
            } else {
                this.messageInProgress = null;
                //todo unregister from selector
            }
        }
    }

    public boolean isEmpty() {
        return this.writeQueue.isEmpty() && this.messageInProgress == null;
    }

}
