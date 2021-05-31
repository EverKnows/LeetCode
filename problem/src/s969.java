import com.sun.tools.javac.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jianmiao.xu
 * @date 2021/5/31
 */
public class s969 {
    public List<Integer> pancakeSort(int[] arr) {
        int length = arr.length;

        List<Integer> result = new ArrayList<>();

        for (int i = length; i >= 2; i--) {
            int index = build(arr, i);

            if (index == i - 1) {
                continue;
            }

            if (0 != index) {
                result.add(index + 1);
                reverse(arr, index);
            }

            result.add(i);
            reverse(arr, i - 1);

        }

        return result;
    }

    private void reverse(int[] arr, int k) {
        int[] copy = new int[k + 1];

        for (int i = k; i >= 0; i--) {
            copy[i] = arr[k - i];
        }

        for (int i = 0; i <= k; i++) {
            arr[i] = copy[i];
        }
    }

    private int build(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (target == arr[i]) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new s969().pancakeSort(new int[]{3, 2, 4, 1}));
    }
}