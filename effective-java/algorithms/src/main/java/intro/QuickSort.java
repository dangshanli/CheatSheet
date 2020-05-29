package intro;

/**
 * @author: luzj
 * @date: 2019-01-05
 * @description: 快排,以测试
 */
public class QuickSort {

    void quickSort(Integer[] A, int p, int r) {
        if (p < r) {
            int q = partition(A, p, r);
            quickSort(A, p, q - 1);
            quickSort(A, q + 1, r);
        }
    }

    int partition(Integer[] A, int p, int r) {
        Integer x = A[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (A[j] <= x) {
                i++;
                Integer tmp0 = A[i];
                A[i] = A[j];
                A[j] = tmp0;
            }
        }
        Integer tmp1 = A[i + 1];
        A[i + 1] = A[r];
        A[r] = tmp1;
        return i + 1;
    }

    public static void main(String[] args) {
        Integer[] A = {13,19,9,5,12,8,7,4,21,2,6,11};
        new QuickSort().quickSort(A,0,A.length-1);
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i]+" ");
        }
    }


}
