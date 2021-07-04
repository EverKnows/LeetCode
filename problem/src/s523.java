import java.util.HashMap;
import java.util.Map;

/**
 * @author jianmiao.xu
 * @date 2021/6/2
 */
public class s523 {

    public boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int remain = 0;

        for (int i = 0; i < len; i++) {
            remain = (remain + nums[i]) % k;

            if (map.containsKey(remain)) {

                Integer pre = map.get(remain);

                if (i - pre + 1 >= 1) {
                    return true;
                }
                continue;
            }

            map.put(remain, i);
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new s523().checkSubarraySum(new int[] { 23, 2, 4, 6, 6 }, 7));
    }
}