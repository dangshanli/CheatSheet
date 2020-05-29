package formula;

/**
 * @author: luzj
 * @date: 2019-01-14
 * @description:
 */
public interface Formula {

    double calculate(int a);

default double sqrt(int a){//扩展函数，可以在接口中写实现方法的语法
        return Math.sqrt(a);
    }
}
