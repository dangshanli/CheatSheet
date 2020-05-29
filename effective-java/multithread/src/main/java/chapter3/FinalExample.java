package chapter3;

/**
 * @author luzj
 * @description:
 * @date 2018/10/6
 */
public class FinalExample {
    int i ;
    final int j;

    static FinalExample obj;

    public FinalExample() {
        this.i = 1;
        this.j = 2;
    }

    public static void writer(){
        obj = new FinalExample();
    }

    public static void reader(){
        FinalExample object = obj;
        int a = object.i;
        int b = object.j;
        System.out.println(a+","+b);
    }

    public static void main(String[] args) {

       Thread t = new Thread(()->{
           writer();
       });

        Thread t1 = new Thread(()->{
            reader();
        });

        t.start();
        t1.start();
    }
}
