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

        int leftBall = m - 2;

        int dis = position[position.length - 1] - position[0];

        int index = position.length - 1;

        while(leftBall > 0) {
            int target = ((position[index] - position[0]) * leftBall) / (leftBall + 1) + position[0];
            int newIndex = findIndex(position, target);
            dis = Math.min(position[index] - position[newIndex], dis);
            leftBall--;
            index = newIndex;
        }

        return Math.min(dis, position[index] - position[0]);
    }

    public int findIndex(int[] position, int target) {

        if (position.length == 1) {
            return 0;
        }

        int left = 0;

        int right = position.length - 1;

        while(left < right) {
            int mid = left + (right - left) / 2;

            if (position[mid] > target) {
                right = mid;
            } else if (position[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return right;
    }

    public static void main(String[] args) {
        System.out.println(new s1552().maxDistance(new int[] { 1 ,2 ,3 ,4 ,5 ,6 ,7 ,8 ,9 , 10}, 4));
    }
}