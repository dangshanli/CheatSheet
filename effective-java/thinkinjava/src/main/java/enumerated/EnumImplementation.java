package enumerated;

import net.mindview.util.Generator;

import java.util.Random;

/**
 * @author luzj
 * @description:
 * 0 enum不可以继承，但是可以实现多个接口
 * @date 2019/4/23
 */
enum CartoonCharacter implements Generator<CartoonCharacter> {
    SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, BUTTY, BOB,;
    private Random random = new Random(47);

    /**
     * 从enum中随机获取一个实例对象
     * @return
     */
    @Override
    public CartoonCharacter next() {
        return values()[random.nextInt(values().length)];
    }
}

public class EnumImplementation{
    /**
     * 打印随机元素
     * @param generator
     * @param <T>
     */
    public static <T> void printNext(Generator<T> generator){
        System.out.println(generator.next()+", ");
    }

    public static void main(String[] args) {
        CartoonCharacter cc = CartoonCharacter.BOB;
        for (int i = 0; i < 10; i++) {
            printNext(cc);
        }
    }
}
