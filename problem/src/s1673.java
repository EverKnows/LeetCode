import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author jianmiao.xu
 * @date 2021/5/31
 */
public class s1673 {


    public int[] mostCompetitive(int[] nums, int k) {
        int len = nums.length;

        Deque<Integer> stack = new LinkedList<>();
        stack.push(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            while(!stack.isEmpty() && nums[i] < stack.peekLast() && (stack.size() + len - i - 1) >= k) {
                stack.removeLast();
            }

            stack.addLast(nums[i]);
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = stack.pollFirst();
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new s1673().mostCompetitive(new int[] {2,4,3,3,5,4,9,6}, 4)));
    }

}