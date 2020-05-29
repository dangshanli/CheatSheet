package enumerated.menu;

import static enumerated.menu.Food.*;

/**
 * @author luzj
 * @description: 所有的食物都被归到Food下面
 * @date 2019/4/23
 */
public class TypeOfFood {
    public static void main(String[] args) {
        Food food = Appetize.SALAD;
        food = MainCourse.LASAGNE;
        food = Dessert.GELATO;
        food = Coffee.CAPPUCCINO;
    }
}
