package chapter4;

import java.util.concurrent.TimeUnit;

/**
 * @author luzj
 * @description:
 * @date 2018/10/8
 */
public class SleepUtils {
    public static final void second(long seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
