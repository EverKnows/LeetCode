/**
 * @author jianmiao.xu
 * @date 2021/5/31
 */
public class s342_4 {

    public boolean isPowerOfFour(int n) {
        int bit  = 1;

        if (n < 0) {
            return false;
        }

        for (int i = 0; i < 31; i++) {
            if ((n & (n - 1)) == 0 && (n & bit) != 0) {
                return (i % 2) == 0;
            }

            bit = bit << 1;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new s342_4().isPowerOfFour(123));
    }
}