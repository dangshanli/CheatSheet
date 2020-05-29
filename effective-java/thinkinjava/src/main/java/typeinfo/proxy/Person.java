package typeinfo.proxy;

/**
 * @author luzj
 * @description:
 * @date 2019/4/11
 */
public class Person extends Alived {
    private String name;
    private int age;
    private String addr;


    public Person(String name, int age, String addr, int hp) {
        super(hp);
        this.name = name;
        this.age = age;
        this.addr = addr;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddr() {
        return addr;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", addr='" + addr + '\'' +
                ", hp=" + hp +
                '}';
    }


    @Override
    int damagedBySomething(int damage) {
        if (isDead)
            return hp;
        this.hp = this.hp - damage;
        if (this.hp <= 0)
            isDead = true;
        return this.hp;
    }
}
