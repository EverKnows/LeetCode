package sequence;

import java.util.Arrays;

/**
 * @author jianmiao.xu
 * @date 2021/3/9
 */
public class 最长相同连续序列 {

    public int longestSameSubString(int[] arr) {
        int size = arr.length;

        int[] dp = new int[size];

        int max = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < size; i++) {
            if (arr[i] == arr[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }

            max = Math.max(max, dp[i]);

        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new 最长相同连续序列().longestSameSubString(new int[] { 2, 4, 4, 5, 5, 5, 6 , 6, 11, 6, 6}));
    }

}