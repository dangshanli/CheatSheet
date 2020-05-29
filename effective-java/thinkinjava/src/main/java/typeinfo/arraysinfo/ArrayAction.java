package typeinfo.arraysinfo;

import java.lang.reflect.Array;

/**
 * @author luzj
 * @description:
 * @date 2019/4/19
 */
public class ArrayAction {
    public static void main(String[] args) {
        //使用反射创建数组
        int[] intArray = (int[]) Array.newInstance(int.class,3);

        //访问数组
        Array.set(intArray,0,122);
        Array.set(intArray,1,155);
        Array.set(intArray,2,123);

        System.out.println("int[0]:"+Array.get(intArray,0));
        System.out.println("int[1]:"+Array.get(intArray,1));
        System.out.println("int[2]:"+Array.get(intArray,2));

        //获取数组Class对象
        Class stringClass = String[].class;


    }
}
