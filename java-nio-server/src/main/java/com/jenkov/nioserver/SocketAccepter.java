package com.jenkov.nioserver;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Queue;

/**
 * Created by jjenkov on 19-10-2015.
 * 用于不断接受Socket请求的工具类，但不负责处理
 * 每一个请求生成一个SocketChannel，并包装成Socket对象存储在Queue中
 */
public class SocketAccepter implements Runnable{

    private int tcpPort = 0;
    private ServerSocketChannel serverSocket = null;

    private Queue socketQueue = null;

    //端口以及持有队列依赖于外部注入
    public SocketAccepter(int tcpPort, Queue socketQueue)  {
        this.tcpPort     = tcpPort;
        this.socketQueue = socketQueue;
    }



    public void run() {
        try{
            this.serverSocket = ServerSocketChannel.open();
            this.serverSocket.bind(new InetSocketAddress(tcpPort));
        } catch(IOException e){
            e.printStackTrace();
            return;
        }


        while(true){
            try{
                SocketChannel socketChannel = this.serverSocket.accept();

                System.out.println("Socket accepted: " + socketChannel);

                //todo check if the queue can even accept more sockets.
                this.socketQueue.add(new Socket(socketChannel));

            } catch(IOException e){
                e.printStackTrace();
            }

        }

    }
}
