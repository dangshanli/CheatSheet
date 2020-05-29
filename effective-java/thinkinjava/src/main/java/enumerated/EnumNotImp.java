package enumerated;

import java.util.Random;

/**
 * @author luzj
 * @description:
 * 0 同EnumImplementation，在使用静态方法取代接口实现
 * 1 我觉得主要好处是，失去了繁琐的泛型配置
 * 2 缺点是，不像接口那样易于拓展，如果想加一个enum Car也复用这个逻辑，明显直接实现Generator
 * 是比直接耦合优异的
 * @date 2019/4/23
 */

enum MyCartoonCharacter {
    SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, BUTTY, BOB,;
    private static Random random = new Random(47);

    static MyCartoonCharacter next() {
        return values()[random.nextInt(values().length)];
    }
}

public class EnumNotImp {
    public static void printNext(MyCartoonCharacter em){
        System.out.println(em.next());
    }

    public static void main(String[] args) {
        MyCartoonCharacter myCartoonCharacter = MyCartoonCharacter.BOB;
        for (int i = 0; i < 10; i++) {
            printNext(myCartoonCharacter);
        }
    }
}
