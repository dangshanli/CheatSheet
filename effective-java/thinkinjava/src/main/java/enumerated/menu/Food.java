package enumerated.menu;

/**
 * @author luzj
 * @description:
 * 0 使用一个接口将不同enum分类组织，接口是总大类，内部enum是二级分类
 * 1 Food是总大类，二级分类分别是：开胃菜、主食、甜点、咖啡 （新增凉菜）
 * 2 然后每一个enum下面在分三级分类，比如开胃菜有：沙拉 汤 春卷
 * @date 2019/4/23
 */
public interface Food {
    enum Appetize implements Food{
        SALAD,SOUP,SPRING_ROLLS;
    }

    enum MainCourse implements Food{
        LASAGNE,BURRITO,PAD_THAI,
        LENTILS,HUMMOUS,VINDALOO
    }

    enum Dessert implements Food{
        TIRAMISU,GELATO,BLACK_FOREST_CAKE,
        FRUIT,CREME_CARAMEL
    }

    enum Coffee implements Food{
        BLACK_COFFEE,DECAF_COFFEE,ESPRESSO,
        LATTE,CAPPUCCINO,TEA,HERB_TEA
    }

    /**
     * 凉菜：凉拌黄瓜 生蔬菜 辣椒油拌豆腐
     */
    enum ColdDish implements Food{
        CUCUMBER_SALAD, RAW_VEGETABLES,PRESSED_TOFU_WITH_CHILI_OIL,
    }
}
