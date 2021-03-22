import java.util.Arrays;

/**
 * @author jianmiao.xu
 * @date 2021/3/22
 */
public class SelectSort {

    public void selectSort(int[] arr) {
        int minIndex = 0;

        int len = arr.length;

        for (int i = 0; i < len; i++) {
            minIndex = i;
            for (int j = i; j < len; j++) {
                if (arr[i] > arr[j]) {
                    minIndex = j;
                }
            }

            swap(arr, minIndex, i);
        }

    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] =arr[right];
        arr[right] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,3 ,1, 0,11};
        new SelectSort().selectSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}