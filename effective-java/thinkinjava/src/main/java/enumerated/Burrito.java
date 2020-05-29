package enumerated;
import static enumerated.Spiciness.*;
/**
 * @author luzj
 * @description:
 * 0 墨西哥卷饼，不同辣度的
 * 1 静态导入的enumeration不需要加类型前缀
 * @date 2019/4/23
 */
public class Burrito {
    Spiciness degree;

    public Burrito(Spiciness degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Burrito is "+degree;
    }

    public static void main(String[] args) {
        System.out.println(new Burrito(NOT));
        System.out.println(new Burrito(MEDIUM));
        System.out.println(new Burrito(HOT));
    }

}
