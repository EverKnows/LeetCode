import java.util.Arrays;

/**
 * @author jianmiao.xu
 * @date 2021/6/1
 */
public class s1744 {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int[] limit = new int[candiesCount.length];
        boolean[] result = new boolean[queries.length];
        int sum = 0;
        for (int i = 0; i < candiesCount.length; i++) {
            sum += candiesCount[i];
            limit[i] = sum;
        }

        int count = 0;
        for (int[] query : queries) {
            int min = 1 * (query[1] + 1);
            int max = query[2] * (query[1] + 1);

            int left = query[0] == 0 ? 0 : limit[query[0] - 1];
            int right = limit[query[0]];

            if ((max >= right && min <= right) || (max >= left && max <= right)) {
                result[count++] = true;
                continue;
            }

            result[count++] = false;

        }

        return result;
    }

    public static void main(String[] args) {
        int[][] queries = {{0,2,2},{4,2,4},{2,13,1000000000}};
        System.out.println(Arrays.toString(new s1744().canEat(new int[] { 7, 4, 5, 3, 8 }, queries)));
    }
}