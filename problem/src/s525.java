import java.util.HashMap;
import java.util.Map;

/**
 * @author jianmiao.xu
 * @date 2021/6/3
 */
public class s525 {
    public int findMaxLength(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < len; i++) {
            if (nums[i] == 1) {
                sum++;
            } else {
                sum--;
            }

            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
                continue;
            }

            map.put(sum, i);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new s525().findMaxLength(new int[] { 0, 1, 0, 1 , 0}));
    }
}