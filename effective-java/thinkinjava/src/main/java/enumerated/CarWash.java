package enumerated;

import java.util.EnumSet;

import static net.mindview.util.Print.print;
import static enumerated.CarWash.Cycle.*;

/**
 * @author luzj
 * @description: 洗车服务，可以在基础服务基础上，自由添加新的洗车服务
 * 0 enum内部定义抽象方法，可以在定义enum实例的时候再进行不同实现，类似于策略模式
 * @date 2019/4/24
 */
public class CarWash {

    //服务定义，使用enum
    public enum Cycle {
        UNDERBODY {//车身底盘

            @Override
            void action() {
                print("Spraying the underbody");
            }
        },
        WHEELWASH {//洗轮胎

            @Override
            void action() {
                print("Washing thr wheels");
            }
        },
        PREWASH {//预洗

            @Override
            void action() {
                print("Loosening the dirt");
            }
        },
        BASIC {//基本洗车服务

            @Override
            void action() {
                print("The basic wash");
            }
        },
        HOTWAX {//打热蜡

            @Override
            void action() {
                print("Applying hot wax");
            }
        },
        RINSE {//冲洗

            @Override
            void action() {
                print("Rinsing");
            }
        },
        BLOWDRY {//吹干

            @Override
            void action() {
                print("Blowing dry");
            }
        };

        abstract void action();//抽象方法，用于不同enum对象的不同策略
    }

    EnumSet<Cycle> cycles = EnumSet.of(BASIC, RINSE);

    /**
     * 新增一项服务
     *
     * @param cycle
     */
    public void add(Cycle cycle) {
        cycles.add(cycle);
    }

    /**
     * 执行订阅的服务
     */
    public void washCar() {
        for (Cycle c : cycles) {
            c.action();
        }
    }

    @Override
    public String toString() {
        return cycles.toString();
    }

    public static void main(String[] args) {
        //基本洗车服务
        CarWash wash = new CarWash();
        print(wash);
        wash.washCar();

        //订阅其他服务
        wash.add(BLOWDRY);
        wash.add(BLOWDRY);//重复的服务订阅无效
        wash.add(RINSE);
        wash.add(HOTWAX);
        print(wash);
        wash.washCar();
    }
}
