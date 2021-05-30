import java.util.Arrays;

/**
 * @author jianmiao.xu
 * @date 2021/5/13
 */
public class s1269 {

    public int numWays(int steps, int arrLen) {
        int[][] dp = new int[steps + 1][arrLen];

        //arrLen = Math.min(arrLen - 1, steps);

        int mod = 1000000007;

        dp[0][0] = 1;

        for (int i = 1; i <= steps; i++) {

            for (int j = 0; j < arrLen; j++) {

                dp[i][j] = dp[i - 1][j];

                if (j + 1 < arrLen) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % mod ;
                }

                if (j - 1 >= 0) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % mod;
                }

            }
        }

        //final int MODULO = 1000000007;
        //int maxColumn = Math.min(arrLen - 1, steps);
        //int[][] dp = new int[steps + 1][maxColumn + 1];
        //dp[0][0] = 1;
        //for (int i = 1; i <= steps; i++) {
        //    for (int j = 0; j <= maxColumn; j++) {
        //        dp[i][j] = dp[i - 1][j];
        //        if (j - 1 >= 0) {
        //            dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % MODULO;
        //        }
        //        if (j + 1 <= maxColumn) {
        //            dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % MODULO;
        //        }
        //    }
        //}

        return dp[steps][0];
    }

    public static void main(String[] args) {

        s1269 s1269 = new s1269();

        System.out.println(s1269.numWays(6, 13));
    }
}