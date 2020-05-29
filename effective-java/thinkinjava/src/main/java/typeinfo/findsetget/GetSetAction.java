package typeinfo.findsetget;

import java.lang.reflect.Method;

/**
 * 获取一个类的getter/setter方法
 * 前提：
 *  所有getter方法都是以get开头，没有入参，you一个返回值
 *  所有的setter都是以set开头的，有一个入参，可能有返回值也可能没有
 */
public class GetSetAction {

    public static boolean isGetter(Method method){
        if (!method.getName().startsWith("get"))return false;
        if (method.getParameterCount() != 0)return false;
        if (void.class.equals(method.getReturnType())) return false;
        return true;
    }

    public static boolean isSetter(Method method){
        if (!method.getName().startsWith("set")) return false;
        if (method.getParameterCount() != 1) return false;
        return true;
    }

    public static void main(String[] args) {
        //打印一个类的所有getter/setter方法
        Method[] methods = Singer.class.getDeclaredMethods();
        for (Method m:methods) {
            if (isGetter(m)) System.out.println("getter:"+m);
            if (isSetter(m)) System.out.println("setter:"+m);
        }
    }

}