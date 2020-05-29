package intro;

/**
 * @author: luzj
 * @date: 2019-01-03
 * @description: 优先队列(按照伪代码实现，未测试)
 */
public class PriorityQueue {

    Heap heap;

    public PriorityQueue(Integer[] A) {
        this.heap = buildMaxHeap(A);
    }


    /**
     * 查看最大优先值
     * @return
     */
    public Integer heapMaximum() {
        return heap.get(1);
    }

    /**
     * 分离最大优先值
     * @return
     */
    public Integer heapExtractMax(){
        if (heap.heapSize < 1)
            return null;
        Integer max = heap.get(1);
        heap.set(1,heap.get(heap.heapSize));
        heap.heapSize--;
        maxHeapify(heap,1);
        return max;
    }

    /**
     * 给某个节点升key（权重）
     * @param i
     * @param key
     */
    void heapIncreaseKey(int i,Integer key){
        if (key < heap.get(i))//减权重则直接退出
            return;
        heap.set(i,key);

        //重排升权重后的堆
        while (i > 1 && heap.get(heap.getParent(i)) < heap.get(i)){
            heap.exchange(i,heap.getParent(i));
            i = heap.getParent(i);
        }
    }

    /**
     * 堆插入新节点
     * @param key
     */
    void maxHeapInsert(Integer key){
        heap.heapSize++;
        heap.set(heap.heapSize,Integer.MIN_VALUE);
        heapIncreaseKey(heap.heapSize,key);
    }

    /**
     * 维护堆的性质(最大堆)
     *
     * @param heap
     * @param i
     */
    private void maxHeapify(Heap heap, int i) {
        int l = heap.getLeft(i),
                r = heap.getRight(i),
                p = heap.getParent(i);

        int largest;
        if (l >= 1 && l <= heap.getHeapSize() && heap.get(l) > heap.get(i))
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
     *
     * @param A 原始数组
     * @return 最大堆
     */
    private Heap buildMaxHeap(Integer[] A) {
        Heap heap = new Heap(A);
        for (int i = Math.floorDiv(heap.getLength() - 1, 2); i >= 1; i--) {
            maxHeapify(heap, i);
        }
        return heap;
    }

    public static void main(String[] args) {
        Integer[] A = {Integer.MIN_VALUE,3,5,67,23,22,11,34,55,89,112,189,98};
        PriorityQueue queue = new PriorityQueue(A);
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i]+" ");
        }
        System.out.println();

        System.out.println(queue.heapMaximum());
        System.out.println(queue.heapExtractMax());
        System.out.println(queue.heapMaximum());
        queue.maxHeapInsert(999);
        System.out.println(queue.heapMaximum());
        queue.heapIncreaseKey(3,2000);
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i]+" ");
        }
    }
}
