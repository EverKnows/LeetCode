/**
 * @author jianmiao.xu
 * @date 2021/5/31
 */
public class s704 {

    public int search(int[] nums, int target) {
        int left = 0;

        int right = nums.length - 1;

        //if (nums.length == 1 && nums[0] == target) {
        //    return 0;
        //}

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new s704().search(new int[] { -1 }, -1));
    }
}