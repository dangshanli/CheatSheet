package chapter4.threadpool;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author luzj
 * @description: 简单的服务端
 * 0 使用线程池实现多线程处理
 * 1 socket作为通信工具
 * 2 只能刷图片和字符
 * @date 2018/10/11
 */
public class SimpleHttpServer {
    static ThreadPool<HttpRequestHandler> threadPool = new DefaultThreadPool(5);//使用线程池处理后端请求
    static String basePath;//资源根地址
    static ServerSocket serverSocket;//前后端请求本质依靠的是socket
    static int port = 8080;//端口

    public static void main(String[] args) throws IOException {
        setBasePath("C:\\idea_project\\SpringBootPractice\\EffectiveJava\\src\\main\\resources\\public");
        start();
    }

    public static void setPort() {
        if (port > 0)
            SimpleHttpServer.port = port;
    }

    public static void setBasePath(String basePath) {
        if (basePath != null && new File(basePath).exists() && new File(basePath).isDirectory())
            SimpleHttpServer.basePath = basePath;
    }

    //服务端的启动方法
    public static void start() throws IOException {
        serverSocket = new ServerSocket(port);
        Socket socket = null;
        while ((socket = serverSocket.accept()) != null) {//将前端请求转化为socket
            threadPool.execute(new HttpRequestHandler(socket));//socket的处理包装成一个Job,然后扔该线程池处理
        }
        serverSocket.close();
    }

    /**
     * 包装socket的Job类
     * 定义了如何处理socket的方法
     * 0 读取socket的输入流，解析请求路径
     * 1 如果是图片返回http响应头和字节数组
     * 2 如果是字符，返回http响应头和字符串
     */
    static class HttpRequestHandler implements Runnable {
        private Socket socket;//通信端口

        public HttpRequestHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            String line = null;
            BufferedReader reader = null;
            BufferedReader br = null;
            PrintWriter out = null;
            InputStream in = null;

            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String header = reader.readLine();
                System.out.println(header);
                String filePath = basePath + header.split(" ")[1];//解析文件请求路径
                System.out.println(filePath);
                out = new PrintWriter(socket.getOutputStream());
                if (filePath.endsWith("jpg") || filePath.endsWith("ico")) {//如果请求图片
                    in = new FileInputStream(filePath);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    int i = 0;
                    while ((i = in.read()) != -1) {
                        baos.write(i);
                    }

                    byte[] array = baos.toByteArray();
                    out.println("HTTP/1.1 200 OK");
                    out.println("Server: Molly");
                    out.println("Content-Type: image/jpeg");
                    out.println("Content-Length: " + array.length);
                    System.out.println("length:" + array.length);
                    out.println("");
                    OutputStream stream = socket.getOutputStream();
                    stream.write(array);
//                    socket.getOutputStream().write(array, 0, array.length);
                } else {//如果请求字符串
                    br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
                    out.println("HTTP/1.1 200 OK");
                    out.println("Server: Molly");
                    out.println("Content-Type: text/html; charset=UTF-8");
                    out.println("");
                    while ((line = br.readLine()) != null) {
                        System.out.println("line==========" + line);
                        out.println(line);
                    }
                }
                out.flush();
            } catch (Exception e) {
                e.printStackTrace();
                out.println("HTTP/1.1 500");
                out.println("");
                out.flush();
            } finally {
                close(br, in, reader, out, socket);
            }
        }
    }

    private static void close(Closeable... closeables) {
        if (closeables != null) {
            for (Closeable c : closeables) {
                try {
                    c.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

