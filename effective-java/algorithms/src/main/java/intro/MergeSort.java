package intro;

/**
 * @author: luzj
 * @date: 2019-01-07
 * @description: 归并排序
 * 大致思想：
 * 0 将数组A拆成B和C
 * 1 对B和C单独排序
 * 2 合并B和C成一个有序数组
 * 3 B和C的排序方式同A，此为递归的基础
 */
public class MergeSort {

    /**
     * 排序
     * @param A
     * @param p
     * @param r
     */
    void sort(Integer[] A, int p, int r) {
        if (p < r) {//开始回归的基本条件，确保最小数组大小为1结束递归
            int q = Math.floorDiv(p + r, 2);
            sort(A, p, q);
            sort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }

    /**
     * 合并两个子数组
     * 其实是将左右两个已经排序的子数组，进行原址排序
     * @param A
     * @param p 左边子数组的边界
     * @param q 左右子数组的分界点
     * @param r 右边子数组的边界
     * 该方法的增长率为：O(n)
     */
    void merge(Integer[] A, int p, int q, int r) {
        int n1 = q - p + 1;//左边子数组的元素个数
        int n2 = r - q; //右边子数组的元素个数

        //将A数组拆成两个数组来装
        Integer[] L = new Integer[n1 + 1];
        Integer[] R = new Integer[n2 + 1];
        for (int i = 0; i < n1; i++) {
            L[i] = A[p + i];
        }

        for (int j = 0; j < n2; j++) {
            R[j] = A[q + j + 1];
        }

        //哨兵，当某个子数组已经遍历完后还接着遍历时，哨兵将很好的阻止越界并且将遍历转向另一个子数组
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;
        int i = 0, j = 0;

        //重排，每次都进行比较，将较小的装进A数组(如果是降序排列，则塞较大的)
        for (int k = p; k <= r; k++) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] A = {5,2,4,7,1,3,2,6};
        new MergeSort().sort(A,0,A.length-1);
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i]+" ");
        }
    }
}
