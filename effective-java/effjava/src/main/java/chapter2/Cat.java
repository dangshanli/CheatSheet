package chapter2;

/**
 * @author luzj
 * @description: 展示使用静态方法获取示例的方式，与Dog对象形成对比
 * @date 2018/8/31
 */
public class Cat {
    private String name;
    private int weight;

    //禁止直接实例化
    private Cat() {
    }

    /**
     * name转小写 体重+20
     * @param name
     * @param weight
     * @return
     */
    public static Cat nameLower(String name, int weight){
        Cat cat = new Cat();
        cat.name = name.toLowerCase();
        cat.weight = weight +20;
        return cat;
    }

    /**
     * name转大写 体重*3
     * @param name
     * @param weight
     * @return
     */
    public static Cat nameUpper(String name,int weight){
        Cat cat = new Cat();
        cat.name = name.toUpperCase();
        cat.weight = weight * 3;
        return cat;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    public static void main(String[] args) {
        Cat c1 = Cat.nameLower("Lily",20);
        Cat c2 = Cat.nameUpper("Lily",20);
        System.out.println(c1);
        System.out.println(c2);
    }
}
