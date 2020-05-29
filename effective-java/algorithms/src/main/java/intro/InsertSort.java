package intro;

/**
 * @author: luzj
 * @date: 2019-01-06
 * @description: 插入排序，增长率为O(n^2)
 * 0 从第二位开始进行比较排序，朝前面有序数列插入新值
 * 1 因此，每插入一个新值，就要遍历前面的有序数列，时间为O(n*n)
 * 2 在比较小的输入下，实际上使用插入反倒比快排、归并等经济
 */
public class InsertSort {

    void insertionSort(Integer[] A) {
        for (int j = 1; j < A.length; j++) {
            Integer key = A[j];
            //想象一下，将A[j]插到有序数列A[0...j-1]中去
            //如果A[j]大于A[j-1]，那么A[j]就直接坐落于A[j]的位置，不要重排
            //若A[j]位于A[0...j-1]中，那么就逐个和A[j-1...0]比较，寻找合适的位置
            int i = j - 1;
            while (i >= 0 && A[i] > key) {
                A[i + 1] = A[i];
                i--;
            }
            A[i + 1] = key;
        }
    }

    //测试
    public static void main(String[] args) {
        Integer[] A= {5,2,4,6,1,3};
        new InsertSort().insertionSort(A);
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i]+" ");
        }
    }

}
