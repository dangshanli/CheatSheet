package containers;

/**
 * @author luzj
 * @description: 测试类
 * @date 2019/5/28
 */
public abstract class Test<C> {
    String name;

    public Test(String name) {
        this.name = name;
    }

    /**
     *    容器测试逻辑
     */
    abstract int test(C container,TestParam tp);
}
