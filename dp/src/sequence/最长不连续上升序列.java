package sequence;

import java.util.Arrays;

/**
 * @author jianmiao.xu
 * @date 2021/3/8
 */
public class 最长不连续上升序列 {

    public int longestIncreasingSequence(int[] arr) {
        int size = arr.length;
        int[] dp = new int[size];

        Arrays.fill(dp, 1);

        // 暴力求解
        int max = 1;
        for (int i = 1; i < size; i++) {
            for (int j = i; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new 最长不连续上升序列().longestIncreasingSequence(new int[] { 5, 9, 4, 3, 1}));

        // 面试题 17.08. 马戏团人塔
    }
}