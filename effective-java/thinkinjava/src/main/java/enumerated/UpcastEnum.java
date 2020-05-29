package enumerated;

/**
 * @author luzj
 * @description:
 * 0 enum Search向上转型会失去调用values()方法的能力
 * 1 但是通过调用其Class对象的getEnumConstants()仍然可以获得他的类对象
 * @date 2019/4/23
 */
public class UpcastEnum {
    public static void main(String[] args) {
        Search[] vals = Search.values();
        Enum e = Search.HITHER;//向上转型
//        e.values(); //向上转型就不可调用values(),编译就不通过
        for (Enum en:e.getClass().getEnumConstants()) {
            System.out.println(en);
        }
    }



}
