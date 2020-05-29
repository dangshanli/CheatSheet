package enumerated;

import static net.mindview.util.Print.*;

/**
 * @author luzj
 * @description:
 * 0 Enum类的基本api:ordinal() name() Enum.valueOf(Class enumClass,String name)等
 * 1 compareTo equals == 三者的结果一直
 *
 * @date 2019/4/23
 */
public class EnumClass {
    public static void main(String[] args) {
        for (Shrubbery s : Shrubbery.values()) {
            print(s + " ordinal: " + s.ordinal());
            printnb(s.compareTo(Shrubbery.CRAWLING) + " ");
            printnb(s.equals(Shrubbery.CRAWLING)+" ");
            print(s == Shrubbery.CRAWLING);
            print(s.getDeclaringClass());
            print(s.name());
            print("-----------------------------------");
        }

        for (String s : "HANGING CRAWLING GROUND".split(" ")) {
            Shrubbery shub = Enum.valueOf(Shrubbery.class, s);
            print(shub);
        }
    }
}
