package typeinfo.classinfo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * Class 对象的API演示
 */
public class ClassAction {


    public static void main(String[] args) throws ClassNotFoundException {
        Class cl = Immortal.class;
        Class cln = Class.forName("typeinfo.classinfo.Immortal");
        System.out.println(cl == cln);

        //get name
        System.out.println("//*****************class name****************//");
        System.out.println(cl.getName());
        System.out.println(cl.getSimpleName());
        System.out.println(cl.getCanonicalName());
        System.out.println(cl.getTypeName());

        System.out.println("//*****************class modifier****************//");
        //modifier
        int modifier = cl.getModifiers();
        System.out.println(Modifier.isPublic(modifier));
        System.out.println(Modifier.isStatic(modifier));
        System.out.println(Modifier.isStrict(modifier));
        System.out.println(Modifier.isStrict(modifier));
        System.out.println(Modifier.isFinal(modifier));

        //package
        System.out.println("//*****************package****************//");
        Package pa = cl.getPackage();
        System.out.println(pa.getName());
        System.out.println(pa.getImplementationVersion());
        Arrays.asList(pa.getAnnotations()).stream().forEach(t -> {
            System.out.println(t);
        });

        //super class
        System.out.println("//*****************super class****************//");
        Class superClass = cl.getSuperclass();
        System.out.println(superClass.getTypeName());

        //imp interface
        System.out.println("//*****************interface****************//");
        Class[] interfaces = cl.getInterfaces();
        Arrays.asList(interfaces).stream().forEach(t -> {
            System.out.println(t.getTypeName());
            System.out.println(t.isInterface());
            System.out.println(Modifier.isPublic(t.getModifiers()));
            System.out.println(t.getPackage());
        });

        //constructor
        System.out.println("//*****************constructor****************//");
        Constructor[] constructors = cl.getConstructors();
        Arrays.asList(constructors).stream().forEach(t -> {
            System.out.println(t.getName());
        });

        //methods
        System.out.println("//*****************methods****************//");
        Arrays.asList(cl.getMethods()).stream().forEach(t -> {
            System.out.println(t.getName());
            System.out.println(Modifier.isPublic(t.getModifiers()));
            System.out.println(t.getReturnType().getTypeName());
            System.out.println(t.getParameterCount());
            Class[] s = t.getParameterTypes();
            Arrays.asList(s).forEach(m -> {
                System.out.print(m != null ? m.getTypeName() : null+"\t");
            });
            System.out.println();
            System.out.println("------------fengexian----------");
        });

        System.out.println("//*****************Declared methods****************//");
        Arrays.asList(cl.getDeclaredMethods()).stream().forEach(t->{
            System.out.println(t.getName());
            System.out.println(Modifier.isPublic(t.getModifiers()));
            System.out.println(t.getReturnType().getTypeName());
            System.out.println(t.getParameterCount());
            Class[] s = t.getParameterTypes();
            Arrays.asList(s).forEach(m -> {
                System.out.print(m != null ? m.getTypeName() : null+"\t");
            });
            System.out.println();
            System.out.println("------------fenge----------");
        });

        //fields
        System.out.println("//*****************fields****************//");
        Arrays.asList(cl.getDeclaredFields()).stream().forEach(t->{
            System.out.print(t.getName()+"\t");
            System.out.println(t.getType().getTypeName());
        });

        //annotations
        System.out.println("//*****************annotations****************//");
        Arrays.asList(cl.getAnnotations()).stream().forEach(t->{
            System.out.println(t.toString());
        });




    }

}
