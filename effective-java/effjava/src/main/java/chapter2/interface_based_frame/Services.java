package chapter2.interface_based_frame;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author luzj
 * @description: 不可实例化的类，提供服务的注册以及访问功能
 * @date 2018/8/31
 */
public class Services {
    private Services(){};//禁止实例化
    private static final Map<String,Provider> providers =
            new ConcurrentHashMap<>();
    public static final String DEFAULT_PROVIDER_NAME = "<def>";

    public static void registerDefaultProvider(Provider p){//提供默认注册
        registerProvide(DEFAULT_PROVIDER_NAME,p);
    }

    public static void registerProvide(String name,Provider p){//注册方法
        providers.put(name,p);
    }

    public static Service newInstance(){//实例化默认服务
        return newInstance(DEFAULT_PROVIDER_NAME);
    }

    public static Service newInstance(String name){//实例化方法
        Provider p = providers.get(name);
        if (p == null)
            throw new IllegalArgumentException("no provider registered with name:"+name);
        return p.newService();
    }
}
