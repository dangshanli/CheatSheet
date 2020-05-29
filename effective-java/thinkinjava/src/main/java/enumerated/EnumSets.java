package enumerated;

import java.util.EnumSet;

import static net.mindview.util.Print.*;
import static enumerated.AlarmPoints.*;

/**
 * @author luzj
 * @description:
 * 0 EnumSet的使用：创建 初始化 添加 移除
 * 1 EnumSet就是一个装Enum的Set
 * 2 他的用处在于替代传统的int “位标识”，这种位标识主要用来表达开关信息，一般都是bit级别的操作
 * 但是EnumSet的优越性在于能够将“开关”语义化的表达出来，使代码更加容易理解
 * @date 2019/4/24
 */
public class EnumSets {
    public static void main(String[] args) {
        EnumSet<AlarmPoints> points = EnumSet.noneOf(AlarmPoints.class);//新建空EnumSet
        points.add(BATHROOM);//添加单enum
        print(points);

        points.addAll(EnumSet.of(STAIR1,STAIR2,KITCHEN));//添加EnumSet
        print(points);

        points = EnumSet.allOf(AlarmPoints.class);//初始全Enum
        points.removeAll(EnumSet.of(STAIR1,STAIR2,KITCHEN));//移除EnumSet
        print(points);

        points.removeAll(EnumSet.range(OFFICE1,OFFICE4));
        print(points);

        points = EnumSet.complementOf(points);
        print(points);
    }
}
