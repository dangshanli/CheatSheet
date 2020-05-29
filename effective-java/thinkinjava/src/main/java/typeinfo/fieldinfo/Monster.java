package typeinfo.fieldinfo;

import java.util.Arrays;
import java.util.Date;

/**
 * @author luzj
 * @description:
 * @date 2019/4/18
 */
public class Monster {
    private String name;
    private double height;
    private Date birth;
    private Monster[] friends;

    public Monster() {
    }

    public Monster(String name) {
        this.name = name;
    }

    public Monster(String name, double height, Date birth, Monster[] friends) {
        this.name = name;
        this.height = height;
        this.birth = birth;
        this.friends = friends;
    }

    public void eat(){
        System.out.print(name+ (friends !=null?" and his friends":""));
        if (friends != null){
            Arrays.asList(friends).stream().forEach(t->{
                System.out.print("\t<"+t.getName()+">");
            });
        }
        System.out.println(" start to eat human!!!");

    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Monster{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", birth=" + birth);
        builder.append("\nfriends:");
        for (Monster m:friends) {
            builder.append(m.getName()+" ");
        }
        return builder.toString();
    }

    public String getName() {
        return name;
    }

    public double getHeight() {
        return height;
    }

    public Date getBirth() {
        return birth;
    }

    public Monster[] getFriends() {
        return friends;
    }

    public static void main(String[] args) {
        Monster monster = new Monster("aka",3.44,new Date(),
                new Monster[]{
                new Monster("lily"),
                        new Monster("tom"),
                        new Monster("precira")
                });
        monster.eat();
        System.out.println(monster);
    }
}
