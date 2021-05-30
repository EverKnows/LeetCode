package pkg;

/**
 * @author jianmiao.xu
 * @date 2021/3/23
 */
public class CompletePkg {
    public int maxValue(int[] weight, int[] value, int capacity) {
        int size = weight.length;
        int[] dp = new int[capacity + 1];

        for (int i = 0; i < size; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (weight[i] <= j) {
                    dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
                }
            }
        }

        return dp[capacity];
    }

    public static void main(String[] args) {
        int[] weight = new int[] {1, 3, 4};
        int[] value = new int[] {15, 20, 30};

        System.out.println(new CompletePkg().maxValue(weight, value, 4));
    }
}