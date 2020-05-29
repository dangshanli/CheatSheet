package chapter4;

/**
 * @author luzj
 * @description: 使用 javap -v Synchronized.class 反编译，可得到class文件的字节码
 * @date 2018/10/9
 */
public class Synchronized {
    public static void main(String[] args) {
        synchronized (Synchronized.class) {
        }
        m();
    }

    public static synchronized void m() {
    }
}
