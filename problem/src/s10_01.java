import java.util.Arrays;

/**
 * @author jianmiao.xu
 * @date 2021/5/27
 */
public class s10_01 {

    public void merge(int[] A, int m, int[] B, int n) {
        int[] temp = new int[m];

        for (int i = 0; i < m; i++) {
            temp[i] = A[i];
        }

        int a = 0;
        int b = 0;
        int len = A.length;
        int k = 0;
        while ((a < m) && (b < n)) {
            if (temp[a] <= B[b]) {
                A[k++] = temp[a++];
            } else {
                A[k++] = B[b++];
            }
        }

        while (a < m) {
            A[k++] = temp[a++];
        }

        while (b < n) {
            A[k++] = B[b++];

        }
    }

    /**
     * 逆向指正，从尾巴开始排，防止A原来的元素被覆盖掉
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public void merge2(int[] A, int m, int[] B, int n) {
        int a = m - 1;
        int b = n - 1;
        int k = m + n - 1;

        while(a >= 0 || b >= 0) {
            if (a == -1) {
                A[k--] = B[b--];
            } else if (b == -1) {
                A[k--] = A[a--];
            } else if (A[a] >= B[b]) {
                A[k--] = A[a--];
            } else {
                A[k--] = B[b--];
            }
        }
    }


    public static void main(String[] args) {
        int[] A = { 1, 2, 3, 0, 0, 0 };
        int[] B = { 2, 5, 6 };

        new s10_01().merge2(A, 3, B, 3);

        System.out.println(Arrays.toString(A));
    }

}