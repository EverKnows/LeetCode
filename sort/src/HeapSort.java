import java.util.Arrays;
import java.util.HashMap;

/**
 * @author jianmiao.xu
 * @date 2021/3/4
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] array = { 4, 6, 3, 1, 11, 7 };

        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(array);

        System.out.println(Arrays.toString(array));
    }

    public void heapSort(int[] arr) {
        int len = arr.length;

        for (int i = len / 2 - 1; i >= 0; i--) {
            doSort(arr, i, arr.length);
        }

        for (int i = len - 1; i >= 0; i--) {
            swap(arr, 0, i);
            doSort(arr, 0, i);
        }


    }

    private void doSort(int[] arr, int i, int len) {
        int temp = arr[i];

        int k = 0;

        for (int j = 2 * i + 1; j < len; j = 2 * j + 1) {
            k = j;
            if (k + 1 < len && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            }
        }

        arr[i] = temp;
    }

    public void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

}