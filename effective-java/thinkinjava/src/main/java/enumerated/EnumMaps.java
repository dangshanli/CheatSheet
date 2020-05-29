package enumerated;

import java.util.EnumMap;
import java.util.Map;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;
import static enumerated.AlarmPoints.*;

/**
 * @author luzj
 * @description: 针对不同的警报点，发出不同的命令
 * 0 EnumMap的基本使用法
 * 1 使用命令模式，key是Enum,value是Command对象
 * @date 2019/4/24
 */
public class EnumMaps {
    public static void main(String[] args) {
        EnumMap<AlarmPoints, Command> em = new EnumMap<>(AlarmPoints.class);
        em.put(KITCHEN, new Command() {
            @Override
            public void action() {
                print("Kitchen fire!");
            }
        });

        em.put(BATHROOM, () -> {
            print("Bathroom alert!");
        });

        for (Map.Entry<AlarmPoints, Command> e : em.entrySet()) {
            printnb(e.getKey()+": ");
            e.getValue().action();
        }

        try{
            em.get(UTILITY).action();
        }catch (Exception e){
            print(e);
        }
    }
}
