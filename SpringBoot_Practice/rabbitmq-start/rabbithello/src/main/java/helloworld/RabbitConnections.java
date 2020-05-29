package helloworld;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author: luzj
 * @date: 2018-11-26
 * @description: 获取链接
 * 0 单例模式
 * 1 Connection日后会使用Queue或者List做成连接池，目前不做，等看完《Java并发编程的艺术》之后
 */
public class RabbitConnections {
/*    private String host;
    private static RabbitConnections rabbitConnections = null;

    private RabbitConnections(String host) {
        this.host = host;
    }

    public static synchronized RabbitConnections getRabbitConnections(String host) {
        if (rabbitConnections == null) {
            rabbitConnections = new RabbitConnections(host);
        }
        return rabbitConnections;
    }*/

    /**
     * 获取链接资源，每次都是新的
     * @return
     * @throws IOException
     * @throws TimeoutException
     */
    protected static Connection getConnection(String host) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(host);
        Connection connection = factory.newConnection();
        return connection;
    }

    /**
     * 真.释放链接
     * @param connection
     * @throws IOException
     */
    protected void releaseConnection(Connection connection) throws IOException {
        if (connection != null && connection.isOpen())
            connection.close();
    }
}
