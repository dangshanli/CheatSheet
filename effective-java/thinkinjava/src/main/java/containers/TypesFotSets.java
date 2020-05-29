package containers;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author luzj
 * @description:
 * @date 2019/5/24
 */
public class TypesFotSets {

    //填充Set容器
    static <T> Set<T> fill(Set<T> set,Class<T> type){

        for (int i = 0; i < 10; i++) {
            try {
                set.add(type.getConstructor(int.class).newInstance(i));
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return set;
    }

    static <T> void test(Set<T> set,Class<T> type){
        fill(set,type);
        fill(set,type);
        fill(set,type);
        System.out.println(set);
    }

    public static void main(String[] args) {
        test(new HashSet<HashType>(),HashType.class);
        test(new LinkedHashSet<HashType>(),HashType.class);
        test(new TreeSet<TreeType>(),TreeType.class);

        System.err.println("=========有点问题的=========");
        //HashSet元素不实现合适的hashCode方法会导致重复，但不报错，因为有一个继承自Object的hashCode方法
        test(new HashSet<SetType>(),SetType.class);
        test(new HashSet<TreeType>(),TreeType.class);
        test(new LinkedHashSet<TreeType>(),TreeType.class);
        test(new LinkedHashSet<SetType>(),SetType.class);

        //TreeSet元素不实现Comparable，会导致异常
        test(new TreeSet<HashType>(),HashType.class);
        test(new TreeSet<SetType>(),SetType.class);
    }
}

//用于Set的元素
class SetType {
    int i;

    public SetType(int i) {
        this.i = i;
    }

    //必须定义equals方法
    @Override
    public boolean equals(Object obj) {
        return obj instanceof SetType && (((SetType) obj).i == i);
    }

    @Override
    public String toString() {
        return Integer.toString(i);
    }
}

//用于HashSet的元素
class HashType extends SetType {
    public HashType(int i) {
        super(i);
    }

    //想用HashSet必须定义hashCode
    @Override
    public int hashCode() {
        return i;
    }
}

//用于TreeSet的元素
class TreeType extends SetType implements Comparable<TreeType> {
    public TreeType(int i) {
        super(i);
    }

    //不能简单地使用i1-i2的方式，有可能会导致int数值越界(当int max 减去int min的时候)
    //给TreeSet做元素必须实现Comparable接口
    @Override
    public int compareTo(TreeType o) {
        return o.i < i ? -1 : (o.i == i ? 0 : 1);
    }
}


