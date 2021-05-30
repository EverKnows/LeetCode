/**
 * @author jianmiao.xu
 * @date 2021/5/27
 */
public class s461 {
    public int hammingDistance(int x, int y) {
        int s = x ^ y;
        int count = 0;

        while (s != 0) {
            s = s & (s - 1);
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new s461().hammingDistance(1, 4));
    }
}