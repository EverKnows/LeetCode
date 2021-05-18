import java.util.Arrays;

/**
 * @author jianmiao.xu
 * @date 2021/5/13
 */
public class offer56_1 {

    public int[] singleNumbers(int[] nums) {

        int b = 1;
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ nums[i];
        }

        while ((b & xor) == 0) {
            b = b << 1;
        }

        int xor1 = 0;

        int xor2 = 0;

        for (int num : nums) {
            if ((num & b) != 0) {
                xor1 = xor1 ^ num;
            } else {
                xor2 = xor2 ^ num;
            }
        }

        return new int[]{xor1, xor2};
    }

    public static void main(String[] args) {
        int[] ints = new offer56_1().singleNumbers(new int[] { 1, 2, 10, 4, 1, 4, 3, 3 });
        System.out.println(Arrays.toString(ints));

        //int i = 4;
        //
        //System.out.println(i ^ i);
    }
}