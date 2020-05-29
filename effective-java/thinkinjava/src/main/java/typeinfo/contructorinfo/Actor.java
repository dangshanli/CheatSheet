package typeinfo.contructorinfo;

/**
 * @author luzj
 * @description: 做一个
 * @date 2019/4/18
 */
public class Actor {
    private String name;

    public void mainDisplay(String theater) {
        System.out.println("in " + theater + ", " + name + "display one role!!!");
    }

    public Actor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "name='" + name + '\'' +
                '}';
    }
}
