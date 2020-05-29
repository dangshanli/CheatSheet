package chapter2;

/**
 * @author luzj
 * @description: 营养成分类
 * 重叠构造器，多个构造方法表达各种的参数可选情况
 * 缺陷：
 * 0 当参数膨胀起来后，很难处理，构造函数也极具膨胀
 * 1 令人眼花缭乱的参数列表，极可能造成调用错误
 * @date 2018/9/1
 */
public class NutritionFacts1 {
    private final int servingSize;//必选
    private final int servings;//必选
    private final int calories;//可选
    private final int fat;//可选
    private final int sodium;//可选
    private final int carbohydrate;//可选

    public NutritionFacts1(int servingSize, int servings) {
        this(servingSize,servings,0);
    }

    public NutritionFacts1(int servingSize, int servings, int calories) {
        this(servingSize,servings,calories,0);
    }

    public NutritionFacts1(int servingSize, int servings, int calories, int fat) {
        this(servingSize,servings,calories,fat,0);
    }

    public NutritionFacts1(int servingSize, int servings, int calories, int fat, int sodium) {
        this(servingSize,servings,calories,fat,sodium,0);
    }

    public NutritionFacts1(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }

    public static void main(String[] args) {

    }
}
