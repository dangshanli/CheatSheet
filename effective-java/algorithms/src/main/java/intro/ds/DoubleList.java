package intro.ds;

import java.util.Objects;

/**
 * @author: luzj
 * @date: 2019-01-18
 * @description: 双向的链表的实现
 * 增、删、查的说明
 * 只是说明链表这个概念，无其他任何意义
 */
public class DoubleList<T> {
    Node<T> head;

    /**
     * 插入链表节点,向头部插入
     *
     * @param key
     */
    public void add(T key) {
        Node<T> e = new Node<>(key);
        e.next = head;
        if (head != null)//首次插入
            head.prev = e;

        head = e;//移动head指针
        e.prev = null;//头部prev保持null，尾部next保持null
    }


    /**
     * key 是否在链表中
     * @param key
     * @return true:包含
     */
    public boolean contains(T key){
        if (search(key) != null)
            return true;
        return false;
    }


    /**
     * 删除指定节点
     * @param key
     */
    public void remove(T key){
        Node<T> e;
        if ((e =search(key)) == null)//查看是否存在
            throw new IllegalStateException(key+"not in list");

        if (e.prev != null)//如果e是中间节点
            e.prev.next = e.next;
        else //如果e是head节点，则head重新指向e的next
            head = e.next;

        if (e.next != null)//连通e的prev和next
            e.next.prev = e.prev;
    }


    /**
     * 获取第n个节点的数据(从0开始...)
     * @param n
     * @return
     */
    public T get(int n){
        int i = 0;
        Node<T> e = head;
        while (e!=null && i <n){
            e = e.next;
            i++;
        }
        if (e != null)
            return e.key;
        return null;
    }


    /**
     * 删除指定索引位置的
     * @param n
     */
    public void remove(int n){
        T e = get(n);
        if (e != null){
            remove(e);
        }else
            throw new IllegalArgumentException("索引节点未找到: "+n);
    }


    /**
     * 查找 T key 是否在链表中
     * @param key
     * @return
     */
    private Node search(T key) {
        Objects.requireNonNull(key);
        //从head开始一个个遍历，比较
        Node<T> e = head;
        //直到查找到，或者返回null
        while (e != null && !key.equals(e.key)) {//T泛型必须重写equals()方法
            e = e.next;
        }
        return e;
    }

    /**
     * 仅仅测试列表用
     */
    private void printList(){
        Node<T> e = head;
        System.out.println("//===========================================");
        while (e != null){
            System.out.println(e.key);
            e = e.next;
        }
        System.out.println("//===========================================");
    }

    //双向链表节点,内部私有
    private class Node<T> {

        Node<T> prev;
        Node<T> next;
        T key;

        public Node() {
        }

        public Node(T key) {
            this.key = key;
        }
    }

    //测试
    public static void main(String[] args) {
        DoubleList<Card> list = new DoubleList();

        //添加元素
        for (int i = 0; i < 5; i++) {
            list.add(new Card(i,(int)(Math.random()*20+1),"card: "+i));
        }

        list.printList();

        //按索引获取节点
        Card e = list.get(3);
        System.out.println("get(3): \n\t"+e);
        System.out.println("contains(): \n\t"+list.contains(e));

        //按索引删除
        list.remove(3);
        list.printList();

    }


}
