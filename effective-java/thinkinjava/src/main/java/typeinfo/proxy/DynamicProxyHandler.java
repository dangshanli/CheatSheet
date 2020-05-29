package typeinfo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author luzj
 * @description:
 * @date 2019/4/11
 */
public class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("***proxy: " + proxy.getClass() + ",method: " + method + ",args" + args);
        if (args != null) {
            for (Object arg : args) {
                System.out.println("\t" + arg);
            }
        }
        if (method.getName().equals("killPerson")) {
            Person person = (Person) args[0];
            System.out.println("天要亡我" + person.getName());
            Sword sword = new Sword();
            while (!person.isDead){
//                method.invoke(proxied,person);
                sword.makeDamage(person);
            }
            System.out.println(person);
            System.out.println(person.getName()+" is dead? "+person.isDead);
        }
//            return method.invoke(proxied,args);
        return null;
    }

    public static void main(String[] args) {
        Sword sword = new Sword();
        BigBigNinja bigBigNinja = new BigBigNinja("sekiro", sword);
        Person enermy = new Person("dada", 34, "青云山", 100);
        bigBigNinja.killPerson(enermy);

        System.out.println("==============================");
        Ninja myNinja = (Ninja) Proxy.newProxyInstance(Ninja.class.getClassLoader(),
                new Class[]{Ninja.class}, new DynamicProxyHandler(bigBigNinja));
        myNinja.killPerson(enermy);
    }
}
