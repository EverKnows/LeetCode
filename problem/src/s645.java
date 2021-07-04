import java.util.Arrays;

/**
 * @author jianmiao.xu
 * @date 2021/7/4
 */
public class s645 {

    public int[] findErrorNums(int[] nums) {

        int[] errorNums = new int[2];
        int n = nums.length;
        Arrays.sort(nums);
        int prev = 0;
        for (int i = 0; i < n; i++) {
            int curr = nums[i];
            if (curr == prev) {
                errorNums[0] = prev;
            } else if (curr - prev > 1) {
                errorNums[1] = prev + 1;
            }
            prev = curr;
        }

        if (nums[n - 1] != n) {
            errorNums[1] = n;
        }

        return errorNums;
    }
}