package typeinfo.methodinfo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author luzj
 * @description:
 *
 * @date 2019/4/18
 */
public class MethodAction {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class cl = Doctor.class;
        //获取Method对象
        //操作Method的各种API
        //declaredMethods表示当前类声明的全部方法，methods表示继承+当前的public方法
        System.out.println("-------------获取所有的Method对象---------------");
        Method[] methods =  cl.getDeclaredMethods();
        Arrays.asList(methods).forEach(t->{
            System.out.print("name:"+t.getName());
            System.out.print("\tmodifier:"+t.getModifiers());
            System.out.print("\tparam-count:"+t.getParameterCount());
            System.out.print("\treturnType:"+t.getReturnType().getName());
            System.out.println();
        });

        //获取指定的Method
        System.out.println("--------------获取指定的Method对象--------------");
        Method cure = cl.getDeclaredMethod("cureOnePerson");
        System.out.println(cure.getName());

        //获取参数类型清单
        System.out.println("--------------获取参数类型清单--------------");
        Method addPatient = cl.getDeclaredMethod("addPatient",Patient.class);
        Arrays.asList(addPatient.getParameterTypes()).stream().forEach(t->{
            System.out.println(t.getTypeName());
        });
        System.out.println(addPatient.getReturnType().getTypeName());

        //调用方法
        System.out.println("--------------调用方法--------------");
        Constructor constructor = cl.getConstructor(String.class,Skill.class);
        Doctor doctor = (Doctor) constructor.newInstance("MuRongZhen",Skill.TOP);
        Method add = cl.getDeclaredMethod("addPatient",Patient.class);
        add.invoke(doctor,new Patient("lara",State.BAD));
        Method curemethod = cl.getDeclaredMethod("cureOnePerson");
        curemethod.invoke(doctor);
        Method say = cl.getDeclaredMethod("say");
        say.invoke(doctor);

        //调用私有方法
        System.out.println("--------------调用私有方法--------------");
        Method just = cl.getDeclaredMethod("justAcceptBribes",Integer.TYPE);
        just.setAccessible(true);
        String s = (String) just.invoke(doctor,100);
        System.out.println(s .endsWith("private method invoke 100"));







    }
}
