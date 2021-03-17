import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jianmiao.xu
 * @date 2021/3/10
 */
public class 面试题17_18 {
    public  int[] shortestSeq(int[] big, int[] small) {
        int size = big.length;

        Map<Integer, Integer> record = new HashMap<>();

        for (int i : small) {
            record.put(i, -1);
        }

        int count = small.length;


        int left = 0;

        int right = 0;

        int minSize = big.length;

        for (int i = 0; i < big.length; i++) {
            if (record.containsKey(big[i])) {
                if (record.get(big[i]) == -1) {
                    count--;
                }

                record.put(big[i], i);

                if (count <= 0) {
                    int a = getMin(record);
                    int b = getMax(record);

                    if (minSize > (record.get(b) - record.get(a))) {
                        minSize = record.get(b) - record.get(a);
                        left = record.get(a);
                        right = record.get(b);
                    }
                }
            } else {
                continue;
            }
        }

        return new int[]{left, right};
    }

    private int getMin(Map<Integer, Integer> record) {
        int min = -1;
        int key = -1;

        for (Integer value : record.keySet()) {
            if (min == -1) {
                min = record.get(value);
                key = value;
            } else {
                if (min > record.get(value)) {
                    min = record.get(value);
                    key = value;
                }
            }
        }

        return key;
    }

    private int getMax(Map<Integer, Integer> record) {
        int max = -1;

        int result = -1;

        for (Integer key : record.keySet()) {
            if (max == -1) {
                max = record.get(key);
                result = key;
            } else {
                if (max < record.get(key)) {
                    max = record.get(key);
                    result = key;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                new 面试题17_18().shortestSeq(new int[] { 7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7 },
                                           new int[] { 1, 5, 9 })));
    }
}