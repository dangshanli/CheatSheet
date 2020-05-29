package chapter2;

/**
 * @author luzj
 * @description: 静态工厂实现单例
 * 0 使用私有构造器
 * @date 2018/9/2
 */
public class Elvis {
    private static final Elvis INSTANCE = new Elvis();
    private Elvis(){}

    public static Elvis getInstance(){return INSTANCE;}

    public void leaveTheBuilding(){}
}
