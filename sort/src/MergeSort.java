import java.util.Arrays;

/**
 * @author jianmiao.xu
 * @date 2021/3/22
 */
public class MergeSort {
    public void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (right - left) / 2 + left;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        doMerge(arr, left, mid, right);
    }

    private void doMerge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        while(i <= mid && j <= right) {
            if (arr[i] > arr[j]) {
                temp[k++] = arr[j++];
            } else {
                temp[k++] = arr[i++];
            }
        }

        while(i <= mid) temp[k++] = arr[i++];
        while(j <= right) temp[k++] = arr[j++];

        for (int l = left; l <= right; l++) {
            arr[l] = temp[l - left];
        }
    }

    public static void main(String[] args) {

        int[] arr = { 4, 5, 6, 2, 3, 1, 222, 0 };
        new MergeSort().mergeSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}