/**
 * @author jianmiao.xu
 * @date 2021/3/19
 */
public class Solution33 {


    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }

        int l = 0;

        int r = len - 1;

        int base = nums[0];

        while(l < r) {
            int mid = (r - l) / 2 + l;

            if (nums[mid] == target) {
                return mid;
            }



            if (nums[mid] > base) {
                if (target > base && nums[mid] > target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (target < nums[len - 1] && nums[mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }


        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution33().search(new int[] { 4,5,6,7,0,1,2 }, 0));
    }
}