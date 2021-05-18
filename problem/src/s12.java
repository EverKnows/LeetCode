/**
 * @author jianmiao.xu
 * @date 2021/5/14
 */
public class s12 {
    public String intToRoman(int num) {
        int[] value = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] mark = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

        StringBuilder str = new StringBuilder();
        for (int i = value.length - 1; i >= 0; i--) {
            if (num / value[i] > 0) {
                int count = num / value[i];
                for (int i1 = 0; i1 < count; i1++) {
                    str.append(mark[i]);
                }

                num = num % value[i];
            }

            if (num == 0) {
                break;
            }
        }

        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(new s12().intToRoman(1994));
    }

}