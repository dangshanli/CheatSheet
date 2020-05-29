package formula;

/**
 * @author: luzj
 * @date: 2019-01-14
 * @description:
 */
@FunctionalInterface//声明函数式接口，这样的接口只能有一个抽象方法，可以有多个拓展函数
public interface Converter<T,F> {
    F convert(T from);

//    String from(String f);
}
