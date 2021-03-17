package sequence;

import java.util.Objects;

/**
 * @author jianmiao.xu
 * @date 2021/3/16
 */
public class 最长回文子序列516 {

    public int longestPalindromeSubseq(String s) {
        int max = 1;

        int len = s.length();
        int[][] dp = new int[len][len];

        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (Objects.equals(s.charAt(i), s.charAt(j))) {
                    dp[i][j] = Math.max(Math.max(dp[i][j - 1], dp[i + 1][j]), dp[i + 1][j - 1] + 2);
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }



    public static void main(String[] args) {
        String str = "bbbab";
        System.out.println(new 最长回文子序列516().longestPalindromeSubseq(str));
    }
}