package sequence;

import java.util.Arrays;

/**
 * @author jianmiao.xu
 * @date 2021/3/8
 */
public class 最长连续上升子序列 {
    public int longestIncreasingSubString(int[] arr) {
        int size = arr.length;
        int[] dp = new int[size];

        int max = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < size; i++) {
            if (arr[i] >= arr[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }

            max = Math.max(dp[i], max);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new 最长连续上升子序列().longestIncreasingSubString(new int[] { 111, 6, 3, 2, 5 }));
    }
}