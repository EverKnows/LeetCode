package pkg;

/**
 * @author jianmiao.xu
 * @date 2021/3/23
 */
public class ZeroOnePkg {

    public int maxValue(int[] weight, int[] value, int capacity) {
        int size = weight.length;

        int[][] dp = new int[size + 1][capacity + 1];

        for (int i = 1; i <= capacity; i++) {
            for (int j = 1; j <= size; j++) {
                if (i >= weight[j - 1]) {
                    dp[j][i] = Math.max(dp[j - 1][i], dp[j - 1][i - weight[j - 1]] + value[j - 1]);
                } else {
                    dp[j][i] = dp[j - 1][i];
                }
            }
        }

        return dp[size][capacity];
    }

    public int maxValue2(int[] weight, int[] value, int capacity) {
        int size = weight.length;
        int[] dp = new int[capacity + 1];

        for (int j = 0; j < size; j++) {
            for (int i = capacity; i >= 0; i--) {
                if (i >= weight[j]) {
                    dp[i] = Math.max(dp[i], dp[i - weight[j]] + value[j]);
                }
            }
        }

        return dp[capacity];
    }

    public static void main(String[] args) {
        int[] weight = new int[] { 2, 3, 4, 5 };
        int[] value = new int[] { 3, 4, 5, 6 };

        System.out.println(new ZeroOnePkg().maxValue2(weight, value, 8));
    }
}