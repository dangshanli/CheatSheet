package intro;

/**
 * @author: luzj
 * @date: 2019-01-08
 * @description: 计数排序
 * 主要思想：如果数组中的x有17个比他小的数，那么x就该放在第18位
 *
 * 计数排序假设输入数组坐落于一个较小的区间内，如果区间较大则不合适
 * 计数排序时间为：O(n)
 */
public class CountingSort {

    /**
     * 计数排序
     * @param A 原数组
     * @return 排序数组
     */
    Integer[] sort(Integer[] A) {
        Integer[] B = new Integer[A.length];

        int k = maxEle(A);//计算C需要的位数
        int[] C = new int[k + 1];
        for (int i = 0; i < C.length; i++) {
            C[i] = 0;
        }

        //计算出数组中值为i出现的个数
        for (int j = 0; j < A.length; j++) {
            C[A[j]] = C[A[j]] + 1;
        }

        //计算出<=i的值的元素个数，放在C[i]中，这样i该放在哪，直接去C[i]即可
        for (int i = 1; i < C.length; i++) {
            C[i] = C[i] + C[i - 1];
        }

        for (int j = A.length - 1; j >= 0; j--) {
            B[C[A[j]]-1] = A[j];//由于从0开始计算位数的，所以C[A[j]]-1是需要的
            C[A[j]] = C[A[j]] - 1;//每向B添加一个元素，当前i的计数减1
        }

        return B;
    }

    /**
     * 从A中选出最大的
     *
     * @param A
     * @return
     */
    Integer maxEle(Integer[] A) {
        Integer max = A[0];

        for (int i = 0; i < A.length; i++) {
            if (max < A[i])
                max = A[i];
        }
        return max;
    }


    public static void main(String[] args) {
        Integer[] A = {2, 5, 3, 0, 2, 3, 0, 3};
        Integer[] B = new CountingSort().sort(A);
        for (int i = 0; i < B.length; i++) {
            System.out.print(B[i] + " ");
        }
    }

}
