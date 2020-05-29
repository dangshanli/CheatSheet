package chapter2;

/**
 * @author luzj
 * @description: builder模式
 * 0 即使一个构造函数也能搞定很多个可选参数
 * 1 私有化构造函数，使对象不可变
 * @date 2018/9/2
 */
public class NutritionFacts3 {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder {
        private int servingSize = 0;
        private int servings = 0;

        private int calories = 0;
        private int fat = 0;
        private int carbohydrate = 0;
        private int sodium = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val){
            this.calories = val;
            return this;
        }

        public Builder fat(int val){
            this.fat = val;
            return this;
        }

        public Builder carbohydrate(int val){
            this.carbohydrate = val;
            return this;
        }

        public Builder sodium(int val){
            this.sodium = val;
            return this;
        }

        public NutritionFacts3 build(){
            return new NutritionFacts3(this);
        }
    }

    private NutritionFacts3(Builder builder) {
        this.servingSize = builder.servingSize;
        this.servings = builder.servings;
        this.calories = builder.calories;
        this.carbohydrate = builder.carbohydrate;
        this.fat = builder.fat;
        this.sodium = builder.sodium;
    }

    public static void main(String[] args) {
        //即使
        NutritionFacts3 cocaCola = new NutritionFacts3.Builder(240, 8).//必要参数
                calories(100).sodium(36).carbohydrate(27).build();//可选参数
    }
}
