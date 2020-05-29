package containers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luzj
 * @description:
 * @date 2019/5/27
 */
public class CountedString {
    private static List<String> created = new ArrayList<>();

    private String s;
    private int id = 0;

    public CountedString(String s) {
        this.s = s;
        created.add(s);
        for (String ss : created) {
            if (ss.equals(s))//如果s，则他们的id编号必不相同
                id++;
        }
    }

    @Override
    public String toString() {
        return "[s:"+s+"],[id:"+id+"],[hashCode:"+hashCode()+"]";
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 37 + s.hashCode();
        result = result * 37 + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof CountedString &&
                (s.equals(((CountedString) obj).s)) &&
                (id == ((CountedString) obj).id);
    }
}
