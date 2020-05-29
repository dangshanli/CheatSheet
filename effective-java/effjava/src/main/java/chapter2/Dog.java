package chapter2;

/**
 * @author luzj
 * @description: 展示使用构造器调整参数顺序的方式实例化对象
 * @date 2018/8/31
 */
public class Dog {
    private String name;
    private int weight;

    //狗的名字小写 体重+20
    public Dog(String name,int weight){
        this.name = name.toLowerCase();
        this.weight = weight + 20;
    }

    //狗的名字大写 体重*3
    public Dog(int weight,String name){
        this.name = name.toUpperCase();
        this.weight = weight * 3;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    public static void main(String[] args) {
        Dog d1 = new Dog("Lily",20);
        Dog d2 = new Dog(20,"Lily");
        System.out.println(d1);
        System.out.println(d2);
    }
}
