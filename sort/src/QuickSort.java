import java.util.Arrays;

/**
 * @author jianmiao.xu
 * @date 2021/3/22
 */
public class QuickSort {
    public int[] quickSort(int[] arr) {
        int len = arr.length;
        if (len == 1 || len == 0) {
            return arr;
        }

        int left = 0;
        int right = len -1;

        doQuickSort(arr, left, right);

        return arr;
    }

    public void doQuickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int base = sort(arr, left, right);
        doQuickSort(arr, left, base - 1);
        doQuickSort(arr, base + 1,  right);

    }

    public int sort(int[] arr, int left, int right) {
        int base = arr[left];

        while(left < right) {
            while(left < right && arr[right] >= base) right--;
            arr[left] = arr[right];

            while(left < right && arr[left] <= base) left++;
            arr[right] = arr[left];
        }

        arr[left] = base;
        return left;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{4, 5, 1, 2, 3, 11};
        new QuickSort().quickSort(arr);

        System.out.println(Arrays.toString(arr));
    }


}