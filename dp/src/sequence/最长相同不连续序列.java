package sequence;

import java.util.Arrays;

/**
 * @author jianmiao.xu
 * @date 2021/3/9
 */
public class 最长相同不连续序列 {

    public int longestSameSequence(int[] arr) {
        int size = arr.length;

        int[] dp = new int[size];

        //Arrays.fill(dp, 1);

        int max = 1;
        for (int i = 0; i < size; i++) {

            for (int j = i; j >= 0; j--) {
                if (arr[j] == arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }

                max = Math.max(max, dp[i]);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new 最长相同不连续序列().longestSameSequence(new int[] {6, 1, 6, 1, 6, 1, 1}));
    }

}