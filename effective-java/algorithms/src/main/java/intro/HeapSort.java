package intro;

import static java.lang.Math.random;

/**
 * @author: luzj
 * @date: 2019-01-02
 * @description:
 */
public class HeapSort {

    /**
     * 使用堆结构给数组排序
     * @param A 待排序数组
     */
    void heapSort(Integer[] A){
        Heap heap = buildMaxHeap(A);
        for (int i = A.length-1; i >=2 ; i--) {
            heap.exchange(i,1);
            heap.heapSize--;
            maxHeapify(heap,1);
        }
    }


    /**
     * 维护堆的性质(最大堆)
     *
     * @param heap
     * @param i
     */
    void maxHeapify(Heap heap, int i) {
        int l = heap.getLeft(i),
                r = heap.getRight(i),
                p = heap.getParent(i);

        int largest;
        if (l >=1 && l <= heap.getHeapSize() && heap.get(l) > heap.get(i))
            largest = l;
        else
            largest = i;

        if (r >= 1 && r <= heap.getHeapSize() && heap.get(r) > heap.get(largest))
            largest = r;

        if (largest != i) {
            heap.exchange(largest, i);
            maxHeapify(heap, largest);
        }
    }

    /**
     * 构建最大堆
     * @param A 原始数组
     * @return 最大堆
     */
    Heap buildMaxHeap(Integer[] A) {
        Heap heap = new Heap(A);
        for (int i = Math.floorDiv(heap.getLength() - 1, 2); i >= 1; i--) {
            maxHeapify(heap, i);
        }
        return heap;
    }
    //测试
    public static void main(String[] args) {
        Integer[] A = {-1,1, 34, 22, 12, 5, 9, 67, 90, 24, 55, 66, 77, 57, 87};
//        new HeapSort().buildMaxHeap(A);

        Integer[] B = new Integer[100];
        for (int i = 0; i < B.length; i++) {
            if (i == 0) {
                B[i] = Integer.MIN_VALUE;
                continue;
            }
            B[i] = (int)(random()*1000+1);
        }

        for (int i = 0; i < B.length; i++) {
            System.out.print(B[i]+" ");
        }
        System.out.println();
        new HeapSort().heapSort(B);

        for (int i = 0; i < B.length; i++) {
            System.out.print(B[i]+" ");
        }
    }


}
