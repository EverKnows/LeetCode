/**
 * @author jianmiao.xu
 * @date 2021/3/22
 */
public class BinarySearch {
    public int indexOfArr(int[] arr, int target) {
        if (arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length;

        while (left <= right) {
            int mid = (right - left) / 2 + left;

            if (arr[mid] == target) {
                return mid;
            } else if(arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    // 大于等于num的索引
    public int firstBiggerThanTarget(int[] arr, int num) {
        int len = arr.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;

            if (arr[mid] == num) {
                return mid;
            } else if (arr[mid] > num) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;

    }

    public int lastSmallerThanTarget(int[] arr, int target) {
        int len = arr.length;

        int left = 0;
        int right = len - 1;

        while(left < right) {
            int mid = (right - left) /2 + left;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return (left - 1) == -1 ? 0 : (left - 1);
    }

    public static void main(String[] args) {
        System.out.println(new BinarySearch().lastSmallerThanTarget(new int[] { 1, 3, 4, 5, 6, 78 }, 0));
    }
}