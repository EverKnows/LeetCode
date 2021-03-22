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
           doSort(arr, i, len);
       }

       for (int i = len - 1; i >= 0; i--) {
           swap(arr, 0, i);
           doSort(arr, 0, i);
       }
   }

    private void doSort(int[] arr, int index, int length) {

        int base = arr[index];

        for (int k = 2 * index + 1; k < length; k=2 * k + 1) {

            if ((k + 1) < length && arr[k] < arr[k + 1]) {
                k++;
            }

            if (arr[k] > base) {
                arr[index] = arr[k];
                index = k;
            }
        }

        arr[index] = base;
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}