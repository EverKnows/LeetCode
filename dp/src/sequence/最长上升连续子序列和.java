package sequence;

/**
 * @author jianmiao.xu
 * @date 2021/3/10
 */
public class 最长上升连续子序列和 {

    public int longestIncreasingSubStringSum(int[] arr) {
        int size = arr.length;
        int[] dp = new int[size];

        int max = arr[0];


        for (int i = 0; i < size; i++) {
            dp[i] = arr[i];
            if (i == 0) {
                continue;
            }

            if (arr[i] > arr[i - 1]) {
                if (arr[i] > arr[i - 1]) {
                    dp[i] = dp[i - 1] + arr[i];
                }
            }

            max = Math.max(dp[i], max);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new 最长上升连续子序列和().longestIncreasingSubStringSum(new int[]{4, 5, 50, 3, 2, 3, 11, 12 ,13}));
    }
}