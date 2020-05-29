package enumerated.menu;

/**
 * @author luzj
 * @description:
 * 0 生成一顿饭
 * 1 将Course下面的枚举，每一个生成一个菜的随机实例，循环5次
 * 2 菜品的顺序是固定的：开胃菜 主食 甜点 咖啡 （新增凉菜）
 *
 * @date 2019/4/23
 */
public class Meal {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (Course course:Course.values()) {
                Food food = course.randomSelection();
                System.out.println(food);
            }
            System.out.println("---");
        }
    }
}
