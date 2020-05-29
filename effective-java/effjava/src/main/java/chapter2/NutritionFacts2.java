package chapter2;

/**
 * @author luzj
 * @description: 使用JavaBean模式来初始化对象
 * 优势：0 相比重叠构造器，可以很清晰的初始化想要的任何字段，代码也易读许多
 * 缺陷：0 将构造对象的过程分不到几个独立的setter中，构造过程中JavaBean处于不一致状态，无法通过参数有效性来保持一致性
 * 1 由于有了setter方法，类的成员可以修改，无法把类做成不可变的了
 *
 * @date 2018/9/1
 */
public class NutritionFacts2 {
    private int servingSize = -1;//required
    private int servings = -1;//required
    private int calories = 0;//optional
    private int fat = 0;//..
    private int sodium = 0;//..
    private int carbohydrate = 0;//..

    //无参构造
    public NutritionFacts2() {
    }

    //setter 方法
    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public static void main(String[] args) {
        NutritionFacts2 cocaCola = new NutritionFacts2();
        cocaCola.setServingSize(240);
        cocaCola.setServings(20);
        cocaCola.setCalories(100);
        cocaCola.setSodium(35);
        cocaCola.setCarbohydrate(27);
    }
}
