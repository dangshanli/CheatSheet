package typeinfo.genericsinfo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author luzj
 * @description: 由于泛型擦出的原因，直接从对象获取类型参数是不可能的
 * 泛型擦除：泛型机制实在编译时的语法糖，在运行时都会被改写成Object类型
 * 如果想要获取类型参数，可以通过带类型参数的方法返回值、方法参数以及对象的域
 * @date 2019/4/19
 */
public class GenericAction {
    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException {
        Class cl = Bag.class;
        Method method = cl.getMethod("getBalls");
        //通过方法返回值类型获取类型参数
        //总体思路就是，先拿到Method，再拿到genericReturnType,之后再拿ActualTypeArguments，这就是类型参数
        System.out.println("-----------------通过返回类型拿类型参数--------------------");
        Type returnType = method.getGenericReturnType();
        if (returnType instanceof ParameterizedType) {
            ParameterizedType type = (ParameterizedType) returnType;
            Type[] types = type.getActualTypeArguments();
            for (Type t : types) {
                Class tClass = (Class) t;
                System.out.println("typeArgClass:" + tClass);
            }
        }

        //通过方法的参数类型拿到类型参数
        //思路大致和返回值拿类型参数相同
        System.out.println("-----------------通过参数获取参数类型--------------------");
        Method method1 = cl.getDeclaredMethod("setBalls", List.class);
        Type[] genericTypes = method1.getGenericParameterTypes();
        for (Type g : genericTypes) {
            if (g instanceof ParameterizedType) {
                ParameterizedType aType = (ParameterizedType) g;
                Type[] parameterArgs = aType.getActualTypeArguments();
                for (Type paramType : parameterArgs) {
                    Class paramArg = (Class) paramType;
                    System.out.println("paramArgClass:"+paramArg);
                }
            }
        }

        //思路和前面大致相同，先拿泛型类型，在哪真实类型
        System.out.println("-----------------通过域拿类型参数--------------------");
        Field field = cl.getDeclaredField("balls");
        Type fieldArgType = field.getGenericType();
        if (fieldArgType instanceof  ParameterizedType){
            ParameterizedType parameterizedType = (ParameterizedType) fieldArgType;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            for (Type t:actualTypeArguments) {
                Class ata = (Class) t;
                System.out.println("fieldArgClass:"+ata);
            }
        }


    }
}
