package enumerated;

import java.util.Random;

/**
 * @author luzj
 * @description: 0 一个通用工具类，从enum中随机获取一个实例
 * @date 2019/4/23
 */
public class Enums {
    private static Random rand = new Random(47);

    /**
     * 从cl.getEnumConstants中随机获取一个Enum
     * @param cl
     * @param <T>
     * @return
     */
     public static <T extends Enum<T>>T random(Class<T> cl){
         return random(cl.getEnumConstants());
     }

    /**
     * 从数组中随机获取一个enum
     * @param values
     * @param <T>
     * @return
     */
     public static <T> T random(T[] values){
         return values[rand.nextInt(values.length)];
     }
}
