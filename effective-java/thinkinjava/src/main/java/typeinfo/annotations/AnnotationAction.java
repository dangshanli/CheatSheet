package typeinfo.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnotationAction {
    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException {
        Class cl = Book.class;
        // 获取类级别的全部注解
        System.out.println("------------获取类级别的全部注解--------------");
        Annotation[] annotations = cl.getDeclaredAnnotations();
        System.out.println("annotation size:" + annotations.length);
        for (Annotation a : annotations) {
            if (a instanceof ClassAnnotation) {
                System.out.print("name:" + ((ClassAnnotation) a).name());
                System.out.println("\tvalue:" + ((ClassAnnotation) a).value());
            }
            System.out.println(a.annotationType().getTypeName());
        }

        //获取类级别的指定注解
        System.out.println("------------获取指定类级别的注解--------------");
        ClassAnnotation classAnnotation = (ClassAnnotation) cl.getDeclaredAnnotation(ClassAnnotation.class);
        System.out.println(classAnnotation.name());
        System.out.println(classAnnotation.value());


        //获取Method级别的Annotation
        System.out.println("------------获取方法级别的注解--------------");
        Method readAgain = cl.getDeclaredMethod("readAgain");
        Annotation[] annotations1 = readAgain.getDeclaredAnnotations();
        System.out.println("readAgain annotations size:"+annotations1.length);
        for (Annotation a:annotations1) {
            if (a instanceof MethodAnnotation){
                System.out.println("isGood:"+((MethodAnnotation) a).isGood());
            }
        }
        System.out.println("------------获取指定方法的注解--------------");
        Method readPage = cl.getDeclaredMethod("readPage",int.class);
        MethodAnnotation mAnno = readPage.getDeclaredAnnotation(MethodAnnotation.class);
        System.out.println("isGood:"+mAnno.isGood());

        //获取方法参数注解
        //返回是二维数组，每一行表示的都是一个参数的Annotation数组
        System.out.println("------------获取方法参数的注解--------------");
        Annotation[][] annotations2 = readPage.getParameterAnnotations();
        Class<?>[] types =readPage.getParameterTypes();//参数类型列表
        int i = 0;
        for (Annotation[] an:annotations2) {
            Class type = types[i++];
            for (Annotation a:an) {
                if (a instanceof ParamAnnotation){
                    System.out.println("charm:"+((ParamAnnotation) a).charm());
                }
            }
        }

        //获取域注解
        System.out.println("------------获取指定域的注解--------------");
        Field field = cl.getDeclaredField("name");
        FieldAnnotation fieldAnnotation = field.getAnnotation(FieldAnnotation.class);
        System.out.println("bookFeel:"+fieldAnnotation.bookFeel());

    }
}
