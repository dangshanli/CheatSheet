package typeinfo.toys;

/**
 * @author luzj
 * @description: Class泛型
 * @date 2019/4/10
 */
public class GenericToyTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<FancyToy> fancyToyClass = FancyToy.class;

        FancyToy fancyToy = fancyToyClass.newInstance();
//        Class<Toy> toyClass = fancyToyClass.getSuperclass(); //编译不通过，只能用通配符的方式

        Class<? super FancyToy> toyClass = fancyToyClass.getSuperclass();
//        Toy toy = toyClass.newInstance(); //编译不通过，由于是"FancyToy的某个基类"，所以返回的只能是Object，而不是具体的Toy
        Object obj = toyClass.newInstance();
    }
}
