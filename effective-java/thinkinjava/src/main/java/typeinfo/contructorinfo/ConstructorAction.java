package typeinfo.contructorinfo;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * @author luzj
 * @description: 构造器相关反射的API
 * @date 2019/4/18
 */
public class ConstructorAction {

    public static void main(String[] args) throws NoSuchMethodException {
        Class cl = Oddesay.class;
        //获取构造器
        System.out.println("-----------------获取全部构造器------------------");
        Constructor[] constructors = cl.getConstructors();
        for (Constructor c : constructors) {
            System.out.println(c.getName());
            Arrays.asList(c.getParameterTypes()).stream().forEach(t->{
                System.out.println(t.getTypeName());
            });
            System.out.println();
        }

        System.out.println("-----------------获取指定构造器------------------");
        Constructor cc = cl.getConstructor(Actor[].class);
        System.out.println(cc.getName());

        System.out.println("-----------------使用Constructor实例化------------------");
        Actor[]  actors = {new Actor("卡桑德拉"),new Actor("伯利克里")};
        try {
            //需要注意的是，这里的参数是这里的构造参数是数组
            //但是我们不能直接传入数组，否则数组会被结构成一个可变长列表参数
            //然后报出Exception in thread "main" java.lang.IllegalArgumentException: wrong number of arguments的异常
            //解决方法是将数组转成Object：(Object)actors
            //或者使用Object数组包装：new Object[]{actors}
            Oddesay oddesay = (Oddesay) cc.newInstance((Object) actors);
            oddesay.actorPlay();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}
