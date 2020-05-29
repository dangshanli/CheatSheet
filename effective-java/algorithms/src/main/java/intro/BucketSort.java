package intro;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: luzj
 * @date: 2019-01-10
 * @description: 桶排序
 * <p>
 * 桶排序假设输入都是(0,1]之间的数，切输入的分布比较均匀，没有很多数挤在一块的情况
 * 总体思想是：将输入按区间分割成一块一块的，即bucket中，然后针对每一个bucket进行Insert-Sort
 * 在相对均匀的情况下，期望时间为:O(n)
 */
public class BucketSort {

    public static final int SIZE = 10;//桶容积

    void bucketSort(Integer[] A) {

        int max = A[0], min = A[0];

        //计算输入坐落区间
        for (Integer item : A) {
            if (item > max)
                max = item;
            if (item < min)
                min = item;
        }

        int bucketNum = (max - min) / SIZE + 1;//桶个数
        List<List<Integer>> buckets = new ArrayList();

        // 初始化桶
        for (int i = 0; i < bucketNum; i++) {
            buckets.add(new ArrayList<Integer>());
        }

        //
        for (int i = 0; i < A.length; i++) {
            int index = indexFor(A[i], min, SIZE);
            buckets.get(index).add(A[i]);
        }

        List<Integer> bucket;
        int j = 0;
        // 单独排序每一个桶
        for (int i = 0; i < bucketNum; i++) {
            bucket = buckets.get(i);
            insertSort(bucket);
            for (Integer ele : bucket) {
                A[j++] = ele;
            }
        }

    }

    /**
     * 计算a应该坐落在哪个区间(bucket,桶)内
     *
     * @param a
     * @param min  最小值
     * @param step 分割区间数量，即桶(bucket)的个数
     * @return 桶的序号
     */
    private int indexFor(Integer a, Integer min, int step) {
        return (a - min) / step;
    }

    /**
     * 插入排序
     *
     * @param bucket 桶(其实就是一个链表)
     */
    private void insertSort(List<Integer> bucket) {
        for (int i = 1; i < bucket.size(); i++) {
            int key = bucket.get(i);
            int j = i - 1;

            //将一个新的key(值)插入的有序子链表中
            while (j >= 0 && bucket.get(j) > key){
                bucket.set(j+1,bucket.get(j));
                j--;
            }
            bucket.set(j+1,key);
        }
    }

    //测试
    public static void main(String[] args) {
        Integer[] A = new Integer[150];
        for (int i = 0; i < A.length; i++) {
            A[i] = (int)(Math.random()*1000+1);
            System.out.print(A[i]+" ");
        }
        System.out.println();
        new BucketSort().bucketSort(A);

        for (int j = 0; j < A.length; j++) {
            System.out.print(A[j]+" ");
        }
    }


}
