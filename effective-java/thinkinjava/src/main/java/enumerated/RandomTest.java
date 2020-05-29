package enumerated;

/**
 * @author luzj
 * @description: 随机工具类测试
 * @date 2019/4/23
 */
enum Activity{
    SITTING,LYING,STANDING,HOPPING,RUNNING,DODGING,JUNMPING,FALLING,FLYING,;
}

public class RandomTest {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(Enums.random(Activity.class));
        }
    }
}
