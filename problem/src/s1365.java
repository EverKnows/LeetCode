import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jianmiao.xu
 * @date 2021/5/27
 */
public class s1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {

        int[] temp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }

        Arrays.sort(temp);

        Map<Integer, Integer> map = new HashMap<>();


        for (int i = 0; i < temp.length; i++) {
            if (i == 0) {
                map.put(temp[i], 0);
                continue;
            }

            if (temp[i] != temp[i - 1]) {
                map.put(temp[i], i);
            } else {
                map.put(temp[i], map.get(temp[i - 1]));
            }
        }

        for (int i = 0; i < nums.length; i++) {
            temp[i] = map.get(nums[i]);
        }

        return temp;
    }

    public static void main(String[] args) {
        int[] result = new s1365().smallerNumbersThanCurrent(new int[] { 8, 1, 2, 2, 3 });
        System.out.println(Arrays.toString(result));
    }
}