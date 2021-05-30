

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author jianmiao.xu
 * @date 2021/5/13
 */
public class s17_10 {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.get(num) == null ? 0 : map.get(num) + 1);
        }

        int length = nums.length / 2;

        if (map.get(nums[length]) >= length / 2) {
            return nums[length];
        }

        return -1;
    }


    public int moleVote(int[] nums) {
        int count = 0;

        int pre = -1;

        for (int num : nums) {
            if (count == 0) {
                count++;
                pre = num;
            } else if (pre == num) {
                count++;
            } else {
                count--;
            }
        }

        // 摩尔投票需要检查
        if (count > 0) {
            int n = 0;
            for (int i : nums) if (i == pre) n++;
            if (n > nums.length / 2) return pre;
        }

        return pre;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{1,2,5,9,5,9,5,5,5};

        System.out.println(new s17_10().majorityElement(nums));


        System.out.println(new s17_10().moleVote(nums));
    }
}