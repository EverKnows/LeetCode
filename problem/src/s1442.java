/**
 * @author jianmiao.xu
 * @date 2021/5/18
 */
public class s1442 {

    public int countTriplets(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];

        for (int i = 0; i < arr.length; i++) {
            dp[i][i] = arr[i];
        }

        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                dp[i][j] = dp[i][j - 1] ^ arr[j];

                for (int k = j; k < arr.length; k++) {
                    if (j != k) {
                        dp[j][k] = dp[j][k - 1] ^ arr[k];
                    }

                    if (dp[i][j - 1] == dp[j][k]) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new s1442().countTriplets(new int[] { 2,3 }));
    }


}