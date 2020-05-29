package enumerated;

import java.util.Random;

/**
 * @author luzj
 * @description:
 * @date 2019/4/25
 */
public enum Input {
    NICKEL(5),DIME(10),QUARTER(25),DOLLAR(100),
    TOOTHPASTE(200),CHIPS(75),SODA(100),SOAP(50),
    ABORT_TRANSACTION,
    STOP,;
    //每一个选项的价格，比如quarter需要充值25美分，dollar需要充值100美分，toothpaste需要200美分
    int value;
    Input(int value){
        this.value = value;
    }
    Input(){}
    int amount(){
        return value;
    }

    static Random rand = new Random(47);
    public static Input randomSelection(){
        //不可以选择 STOP 实例
        return values()[rand.nextInt(values().length-1)];
    }
}
