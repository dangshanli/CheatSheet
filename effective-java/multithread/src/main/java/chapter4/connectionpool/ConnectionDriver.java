package chapter4.connectionpool;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.concurrent.TimeUnit;

/**
 * @author luzj
 * @description: 构造Connection驱动
 * 0 真正的数据库连接驱动是由各个厂商实现
 * 1 这里是使用代理去实现Connection接口，实现仅仅是在`commit()`的时候睡眠100ms
 * 2 由于只是一个示例，连接池持有的Connection并不具有连接数据库的能力
 * @date 2018/10/10
 */
public class ConnectionDriver {

    //重写invoke()，统一实现Connection接口，在commit()的时候睡100ms
    static class ConnectionHandler implements InvocationHandler {
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (method.getName().equals("commit"))
                TimeUnit.MILLISECONDS.sleep(100);
            return null;
        }
    }

    //使用代理获取Connection对象
    public static final Connection createConnection() {
        return (Connection) Proxy.newProxyInstance(ConnectionDriver.class.getClassLoader(),
                new Class<?>[]{Connection.class}, new ConnectionHandler());
    }
}
