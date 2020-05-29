package intro;

/**
 * @author: luzj
 * @date: 2019-01-07
 * @description: 一个index从0开始的版本
 * 0 前一个版本单独实现一个Heap结构来解决heapSize的问题，这里heapSize作为入参的一部分，让函数持有。不在单独实现Heap
 * 1 数组从0开始读取，不再在0的位置做一个哨位出来
 * 2 子节点查找方式：Left:2i+1 Right:2i+2
 * 3 总的思路和之前还一样，maxHeapify->buildHeap->sort
 * 归并排序的增长率为：O(nlg(n))
 */
public class HeapSort2 {

    /**
     * 排序
     * @param A 排序数组,原址排序
     */
    void sort(Integer[] A) {
        buildMaxHeap(A);
        for (int i = A.length - 1; i > 0; i--) {
            Integer tmp = A[0];
            A[0] = A[i];
            A[i] = tmp;

            maxHeapify(A, i - 1, 0);
        }
    }

    /**
     * 维护堆,heapSize作为参数维护在函数中
     *
     * @param A
     * @param heapSize 堆大小
     * @param i 针对节点i，维护堆性质
     */
    void maxHeapify(Integer[] A, int heapSize, int i) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int largest;

        if (l <= heapSize && A[l] > A[i])
            largest = l;
        else
            largest = i;
        if (r <= heapSize && A[r] > A[largest])
            largest = r;

        if (largest != i) {
            Integer tmp = A[i];
            A[i] = A[largest];
            A[largest] = tmp;

            maxHeapify(A, heapSize, largest);
        }
    }

    /**
     * 构建堆
     * @param A
     */
    void buildMaxHeap(Integer[] A) {
        int heapSize = A.length - 1;
        for (int i = Math.floorDiv(A.length, 2); i >= 0; i--) {
            maxHeapify(A, heapSize, i);
        }
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        Integer[] A = {-1, 1, 34, 22, 12, 5, 9, 67, 90, 24, 55, 66, 77, 57, 87};
        HeapSort2 sort2 = new HeapSort2();
//        sort2.buildMaxHeap(A);
        sort2.sort(A);
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
        Integer[] B = new Integer[100];
        for (int i = 0; i < B.length; i++) {
            B[i] = (int) (Math.random() * 1000 + 1);
            System.out.print(B[i] + " ");
        }
        System.out.println();
        sort2.sort(B);
        for (int i = 0; i < B.length; i++) {
            System.out.print(B[i] + " ");
        }
    }

}
