package enumerated;
import static net.mindview.util.Print.print;
import static enumerated.Signal.*;


/**
 * @author luzj
 * @description: 0 交通灯处理
 * 1 在switch结构中使用enum。
 * 2 switch只可以处理整数，同时也可以传递enum，因为他取得是enum的ordinal()次序，
 * enum的ordinal()写完就固定了
 * 3 显然，枚举转数值次序的工作编译器直接做了
 * @date 2019/4/23
 */
public class TrafficLight {
    Signal color = RED;

    public void change(){
        switch (color){
            case RED:color = GREEN;break;
            case GREEN:color=YELLOW;break;
            case YELLOW:color=RED;break;
        }
    }

    @Override
    public String toString() {
        return "Traffic light is "+color;
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight();
        for (int i = 0; i < 7; i++) {//改变灯色7次
            print(t);
            t.change();
        }
    }
}
