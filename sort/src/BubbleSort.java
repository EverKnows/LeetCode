import java.util.Arrays;

/**
 * @author jianmiao.xu
 * @date 2021/3/22
 */
public class BubbleSort {

    public void BubbleSort(int[] arr) {
        int end = arr.length - 1;
        int begin = 0;

        int maxIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            maxIndex = 0;
            for (int j = 0; j <= end; j++) {
                if (arr[maxIndex] < arr[j]) {
                    maxIndex = j;
                }
            }
            swap(arr, end, maxIndex);
            end--;
        }
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 2, 3, 41, 1, 0, 21};
        new BubbleSort().BubbleSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}