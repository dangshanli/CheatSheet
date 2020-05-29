package intro.ds;

import java.util.Arrays;

/**
 * @author: luzj
 * @date: 2019-01-17
 * @description: 数组实现队列
 * 队列：FIFO即先进先出 head dequeue，tail enqueue
 * 非线程安全
 * 当队列满的时候，自动扩容
 */
public class Queue<T> {
    private int head, tail;//双索引
    private Object[] elements;//持有元素

    /**
     * 默认10容量
     */
    public Queue() {
        this(10);
    }

    /**
     * 自定义容积
     *
     * @param capacity
     */
    public Queue(int capacity) {
        this.elements = new Object[capacity];
        head = 0;
        tail = 0;
    }

    /**
     * 加入队列
     *
     * @param element
     */
    public void enQueue(T element) {
        if (isFull()) {
            doubleify();
        }
        elements[tail] = element;
        tail = tailPlusOne();
    }

    /**
     * 弹出队列
     *
     * @return
     */
    public T deQueue() {
        if (isEmpty())
            throw new IllegalStateException("队列下溢出!!!");

        T ele = element(head);
        head = headPlusOne();
        return ele;
    }

    /**
     * 队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        if (head == tail)
            return true;
        return false;
    }

    /**
     * 队列大小
     *
     * @return
     */
    public int size() {
        if (tail >= head)
            return tail - head;
        else
            return elements.length - (head - tail);
    }

    /**
     * 队列头部元素
     *
     * @return
     */
    public T head() {
        return element(head);
    }

    private int tailPlusOne() {
        if (tail == elements.length - 1)
            return 0;
        else
            return tail + 1;
    }

    private int headPlusOne() {
        if (head == elements.length - 1)
            return 0;
        else
            return head + 1;
    }

    /**
     * 扩展数组
     */
    private void doubleify() {
        if (tail > head)
            elements = Arrays.copyOf(elements, 2 * elements.length);
        //如果head在tail后面的时候，则需要特殊处理
        else if (tail < head) {
            Object[] midArr = new Object[2 * elements.length];

            //先把0->tail的元素安排了，放在新数组的头部
            for (int i = 0; i <= tail; i++) {
                midArr[i] = elements[i];
            }

            //将head->(length-1)的元素放在新数组的尾部
            int index = midArr.length - 1;
            for (int j = elements.length - 1; j >= head; j--) {
                midArr[index] = elements[j];
                index--;
            }
            elements = midArr;
            head = index + 1;//重置head位置
        }
    }

    private boolean isFull() {
        if (tailPlusOne() == head)
            return true;
        return false;
    }

    private T element(int index) {
        if (index < 0 || index > elements.length - 1)
            throw new ArrayIndexOutOfBoundsException("数组越界!!!");
        return (T) elements[index];
    }

    private int length() {
        return elements.length;
    }

    //测试
    public static void main(String[] args) {

        Queue<Card> queue = new Queue<>(5);

        for (int i = 0; i < 10; i++) {
            queue.enQueue(new Card(i, (int) (Math.random() * 20 + 1), "card " + i));
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(queue.deQueue());
        }
        System.out.println(queue.length());

        for (int i = 10; i < 40; i++) {
            queue.enQueue(new Card(i, (int) (Math.random() * 20 + 1), "card " + i));
        }

        System.out.println("===============分割线==================");
        for (int i = 0; i < 10; i++) {
            System.out.println(queue.deQueue());
        }
        System.out.println("===============分割线==================");
        System.out.println("head> " + queue.head());
        System.out.println("size: " + queue.size());
    }

}
