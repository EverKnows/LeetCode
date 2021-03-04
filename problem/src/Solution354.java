import java.util.Arrays;
import java.util.Comparator;

/**
 * @author jianmiao.xu
 * @date 2021/3/4
 */

/**
 * LIS  最长的上升子序列
 */
public class Solution354 {

    public int maxEnvelopes(int[][] envelopes) {
        int size = envelopes.length;

        int[] count = new int[size];
        Arrays.fill(count, 1);

        Arrays.sort(envelopes, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
               return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < size; i++) {
            for (int j = i; j >= 0; j--) {
                if (isBigger(envelopes[i], envelopes[j])) {
                    count[i] = Math.max(count[i], 1 + count[j]);
                }

            }
        }

        Arrays.sort(count);

        return count[size - 1];

    }

    public boolean isBigger(int[] eve1, int[] eve2) {
        return (eve1[0] > eve2[0]) && (eve1[1] > eve2[1]);
    }

    public static void main(String[] args) {
        int[][] eve = {{5,4}, {6,4}, {6,7}, {2,3}};
        Solution354 solution = new Solution354();
        System.out.println(solution.maxEnvelopes(eve));
    }
}