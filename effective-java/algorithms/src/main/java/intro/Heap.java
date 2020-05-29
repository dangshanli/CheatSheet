package intro;

/**
 * @author: luzj
 * @date: 2019-01-02
 * @description: 为了简化问题不使用泛型，全部使用Integer数组
 */
public class Heap {
    Integer[] A;

    int heapSize;

    private int length;

    public int getLength() {
        return length;
    }

    public Integer get(int index) {
        if (index >= 1 && index < length)
            return A[index];
        return null;
    }

    public void set(int index, Integer val) {
        if (index >= 1 && index < length)
            A[index] = val;
    }

    public void exchange(int index,int des){
        if (index >= 1 && index <length && des >=1 && des < length){
            Integer tmp = A[index];
            A[index] = A[des];
            A[des] = tmp;
        }
    }

    public Heap(Integer[] a) {
        A = a;
        A[0] = Integer.MIN_VALUE;//强制第一位元素作为保留位
        heapSize = a.length - 1;
        length = A.length;
    }

    public int getParent(int index) {
        if (index <= 0 || index >= length)//index越界
            return -1;
        return Math.floorDiv(index, 2);
    }

    public int getLeft(int index) {
        int left = 2 * index;
        if (index < 0 || index >= length || left >= length)//index越界，或者子节点越界
            return -1;
        return left;
    }

    public int getRight(int index) {
        int right = index * 2 + 1;
        if (index < 0 || index >= length || right >= length)//index越界，或者子节点越界
            return -1;
        return right;
    }

    public int getHeapSize() {
        return heapSize;
    }

    public void setHeapSize(int heapSize) {
        this.heapSize = heapSize;
    }

    public static void main(String[] args) {
        if (-1000 > Integer.MIN_VALUE)
            System.out.println(-1000);
    }
}
