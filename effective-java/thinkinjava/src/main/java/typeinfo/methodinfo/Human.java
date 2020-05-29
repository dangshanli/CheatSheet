package typeinfo.methodinfo;

/**
 * @author luzj
 * @description:
 * @date 2019/4/18
 */
public abstract class Human {
    protected String name;

    abstract void say();

    public String getName() {
        return name;
    }
}
