package intro.ds;

import java.util.Arrays;

/**
 * @author: luzj
 * @date: 2019-01-17
 * @description: 使用数组实现的栈
 * LIFO 后进先出
 * 非线程安全
 */
public class Stack<T> {
    private Object[] elements;//持有栈元素
    private int top;//顶部索引

    /**
     * 默认初始化5个元素
     */
    public Stack() {
        this(5);
    }

    /**
     * 自定义初始化数组大小
     *
     * @param cap
     */
    public Stack(int cap) {
        if (cap < 1)
            throw new IllegalArgumentException("a bad capacity: " + cap);
        elements = new Object[cap];
        this.top = 0;
    }

    /**
     * 添加元素
     *
     * @param element
     */
    public void push(T element) {
        if (this.top == elements.length - 1)
            doubleify();
        elements[top] = element;
        this.top++;
    }

    /**
     * 弹出元素，空栈会报异常
     *
     * @return
     */
    public T pop() {
        if (isEmpty())
            throw new ArrayIndexOutOfBoundsException("栈已空!!!");
        else {
            this.top--;
            return element(top);
        }
    }

    /**
     * 栈是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        if (this.top == 0)
            return true;
        else
            return false;
    }

    /**
     * 查看顶部元素，不弹出
     *
     * @return
     */
    public T top() {
        if (isEmpty())
            return null;
        return element(top - 1);
    }

    /**
     * 栈中元素多少
     *
     * @return
     */
    public int size() {
        return this.top;
    }

    private T element(int index) {
        if (index < 0 || index >= top)
            throw new IllegalArgumentException("无效的入参,参数越界!!!");
        return (T) elements[index];
    }

    /**
     * 扩大数组
     */
    private void doubleify() {
        elements = Arrays.copyOf(elements, elements.length * 2);
    }

    //测试
    public static void main(String[] args) {
        Stack<Card> stack = new Stack();
        for (int i = 0; i < 10; i++) {
            stack.push(new Card(i, (int) (Math.random() * 20 + 1), "第" + i + "号卡片"));
        }

        System.out.println("size: " + stack.size());
        System.out.println("isEmpty: " + stack.isEmpty());
        System.out.println("top: " + stack.top);
        System.out.println("====================分割线==================");
        int size = stack.size();

        for (int i = 0; i < size; i++) {
            System.out.println(stack.pop());
        }

        System.out.println("empty: " + stack.isEmpty());
        System.out.println(stack.top());//null
        stack.pop();//此时会报出越界异常
    }
}


