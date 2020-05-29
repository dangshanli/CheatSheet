package chapter2;

/**
 * @author luzj
 * @description:
 * @date 2018/9/3
 */
public class UtilityClass {

    //私有化构造器，防止实例化
    private UtilityClass() {
        //抛出异常，禁止内部实例化或者反射实例化
        throw new AssertionError();
    }
}
