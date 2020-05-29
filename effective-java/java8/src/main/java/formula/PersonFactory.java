package formula;

/**
 * @author: luzj
 * @date: 2019-01-14
 * @description:
 */
public interface PersonFactory<T extends Person> {
    T create(String first,String last);
}
