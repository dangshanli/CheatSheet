package chapter2;

import java.io.Serializable;

/**
 * @author luzj
 * @description:
 * @date 2018/9/2
 */
public class Elvis2 implements Serializable {
    private static final Elvis2 INSTANCE = new Elvis2();

    private Elvis2(){}

    public static Elvis2 getInstance(){
        return INSTANCE;
    }

    private Object readResolve(){
        return INSTANCE;
    }
}
