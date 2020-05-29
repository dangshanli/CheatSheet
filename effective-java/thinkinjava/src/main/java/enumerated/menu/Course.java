package enumerated.menu;

import enumerated.Enums;

/**
 * @author luzj
 * @description: 0 一道菜，枚举Food下的enumerate，将其包装成一个个enumerate实例
 * 1 通过randomSelection获取随机一个enumerate实例下enumerate（枚举的枚举）
 * @date 2019/4/23
 */
public enum Course {
    APPETIZER(Food.Appetize.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class),
    COLDDISH(Food.ColdDish.class)
    ;

    private Food[] values;
    Course(Class<? extends Food> kind) {
        this.values = kind.getEnumConstants();
    }

    //获取一个随机食物
    public Food randomSelection(){
        return Enums.random(values);
    }
}
