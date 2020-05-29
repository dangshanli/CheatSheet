package enumerated;

import net.mindview.util.*;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

import static net.mindview.util.Print.*;

/**
 * @author luzj
 * @description: 使用反射探索enum
 * 0 任何Enum对象都继承自Enum类
 * 1 他们天生都是final class，因此不可再继承
 * 2 编译器会给Enum的子类自动添加values() 和 valueOf()两个方法
 * @date 2019/4/23
 */
public class Reflection {
    public static Set<String> analyze(Class<?> enumClass) {
        print("-------- analyzing " + enumClass + " ----------");
        print("Interfaces:");
        for (Type t : enumClass.getGenericInterfaces()) {
            print(t);
        }
        print("Base: " + enumClass.getSuperclass());
        print("Methods: ");
        Set<String> methods = new TreeSet<>();
        for (Method m : enumClass.getMethods()) {
            methods.add(m.getName());
        }
        print(methods);
        return methods;
    }

    public static void main(String[] args) {
        Set<String> exploreMethods = analyze(Explore.class);
        Set<String> enumMethods = analyze(Enum.class);
        print("Explore.containsAll(Enum)? "+exploreMethods.containsAll(enumMethods));
        printnb("Explore.removeAll(Enum): ");
        exploreMethods.removeAll(enumMethods);
        print(exploreMethods);
        OSExecute.command("javap target/classes/practices/thinkinjava/enumerated/Explore.class");
    }



}
