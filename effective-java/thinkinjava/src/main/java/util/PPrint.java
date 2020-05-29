package util;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author luzj
 * @description: 更好的打印集合打方式
 * @date 2019/4/28
 */
public class PPrint {

    /**
     * 将集合输出成格式化字符串
     * @param c
     * @return
     */
    public static String pformat(Collection<?> c){
        if (c.size() == 0)
            return "[]";
        StringBuilder result = new StringBuilder("[");
        for (Object elem:c) {
            if (c.size() != 1)
                result.append("\n  ");
            result.append(elem);
        }
        if (c.size() != 1)
            result.append("\n  ");
        result.append("]");
        return result.toString();
    }

    /**
     * 打印集合到标准输出流
     * @param c
     */
    public static void pprint(Collection<?> c){
        System.out.println(pformat(c));
    }

    /**
     * 打印数组到标准输出流
     * @param objects
     */
    public static void pprint(Object[] objects){
        System.out.println(pformat(Arrays.asList(objects)));
    }


}
