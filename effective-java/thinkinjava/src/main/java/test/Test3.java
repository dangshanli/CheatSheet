package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luzj
 * @description:
 * @date 2019/5/28
 */
public class Test3 {
    static List<String> ss = new ArrayList<>();
    static {
        ss.add("天上白玉京");
        ss.add("十二楼五城");
        ss.add("仙人抚我顶");
        ss.add("结发受长生");
        ss.add("李白");
    }

    static List backup(){
        return ss;
    }


    public static void main(String[] args) {
        System.out.println(ss);
        List mm = backup();
        mm.set(4,"(●—●)");
        System.out.println(mm);
        System.out.println(ss);
    }
}
