package chapter4.connectionpool;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * @author luzj
 * @description: 实现连接池
 * 0 使用等待-通知机制，等待超时模式
 * 1 fetch同来获取连接
 * 2 release用来释放连接
 * 3 连接资源用依赖双向链表来维护持有
 * @date 2018/10/10
 */
public class ConnectionPool {
    private LinkedList<Connection> pool = new LinkedList<Connection>();//双向链表持有所有的连接

    //初始化连接池
    public ConnectionPool(int initSize) {
        if (initSize > 0) {
            for (int i = 0; i < initSize; i++) {
                pool.add(ConnectionDriver.createConnection());
            }
        }
    }

    //超时获取连接
    public Connection fetchConnection(long mills) throws InterruptedException {
        synchronized (pool) {
            //完全超时,即需要立马获取连接否则返回空
            if (mills < 0) {
                while (pool.isEmpty())
                    pool.wait();
                return pool.removeFirst();
            } else {
                //设置超时时间情况
                long future = System.currentTimeMillis() + mills;
                long remain = mills;
                while (pool.isEmpty() && remain > 0) {
                    pool.wait();//未超时且还还有闲置连接的时候，就等着被唤醒
                    remain = future - System.currentTimeMillis();
                }
                Connection result = null;
                if (!pool.isEmpty())
                    result = pool.removeFirst();
                return result;
            }
        }
    }

    //释放连接资源
    public void releaseConnection(Connection connection) {
        if (connection != null) {
            //释放对象时获取锁，并唤醒所有等待线程来竞争锁
            synchronized (pool) {
                pool.add(connection);
                pool.notifyAll();
            }
        }
    }


}
