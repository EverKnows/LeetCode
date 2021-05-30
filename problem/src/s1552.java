import java.util.Arrays;

/**
 * @author jianmiao.xu
 * @date 2021/5/18
 */
public class s1552 {

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        if (m == 2) {
            return position[position.length - 1] - position[0];
        }

        int left = 0;
        int right = (position[position.length - 1] - position[0]) / (m - 1);
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(mid, position, m)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }


        }

        return ans;
    }

    private boolean check(int mid, int[] position, int m) {
        int pre = position[0];
        int length = position.length;
        int count = 1;
        for (int i = 1; i < length; i++) {
            if (position[i] - pre >= mid) {
                count++;
                pre = position[i];
            }
        }

        return count >= m;
    }



    public static void main(String[] args) {
        System.out.println(new s1552().maxDistance(new int[] { 1 ,2 ,3 ,4 ,5 ,6 ,7 ,8 ,9 , 10}, 4));
    }
}