package typeinfo.methodinfo;

/**
 * @author luzj
 * @description:
 * @date 2019/4/18
 */
public class Patient extends Human {
    State state;

    public Patient(String name,State state) {
        this.name = name;
        this.state = state;
    }

    @Override
    void say() {
        System.out.println("i'm "+state);
    }

    public static void main(String[] args) {
        Patient p = new Patient("LiYun",State.GOOD);
        p.say();
    }
}
