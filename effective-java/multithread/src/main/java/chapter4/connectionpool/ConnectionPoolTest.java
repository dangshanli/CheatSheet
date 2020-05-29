package chapter4.connectionpool;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author luzj
 * @description: 连接池获取测试
 * @date 2018/10/10
 */
public class ConnectionPoolTest {
    static ConnectionPool pool = new ConnectionPool(10);
    static CountDownLatch start = new CountDownLatch(1);//保证所有线程同时执行
    static CountDownLatch end;//保证所有线程执行完毕才继续执行主线程

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 50;
        end = new CountDownLatch(threadCount);
        int count = 20;
        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGot = new AtomicInteger();
        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(new ConnectionRunner(count, got, notGot),
                    "connection_runner_thread");
            thread.start();
        }

        start.countDown();
        end.await();//等所有线程完成后才继续主线程
        System.out.println("total invoke:" + (threadCount * count));//总连接数
        System.out.println("got connection:"+got.get());//成功数
        System.out.println("not got connection:"+notGot.get());//失败数
        BigDecimal b1 = BigDecimal.valueOf(threadCount*count);
        BigDecimal b2 = BigDecimal.valueOf(got.get());
        System.out.println(b2.divide(b1,4,BigDecimal.ROUND_CEILING).doubleValue());//成功率
    }


    static class ConnectionRunner implements Runnable {
        int count;//获取连接数
        AtomicInteger got;//统计获取连接成功次数
        AtomicInteger notGot;//获取连接不成功次数

        public ConnectionRunner(int count, AtomicInteger got, AtomicInteger notGot) {
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }

        public void run() {
            try {
                start.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            while (count > 0) {
                try {
                    Connection connection = pool.fetchConnection(1000);
                    if (connection != null) {
                        try {
                            connection.createStatement();
                            connection.commit();
                        } finally {
                            pool.releaseConnection(connection);
                            got.incrementAndGet();
                        }
                    } else {
                        notGot.incrementAndGet();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    count--;
                }
            }
            end.countDown();//end减1
        }
    }


}
