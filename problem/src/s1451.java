import java.util.Arrays;
import java.util.Comparator;

/**
 * @author jianmiao.xu
 * @date 2021/5/27
 */
public class s1451 {
    public String arrangeWords(String text) {
        String[] letters = text.toLowerCase().split(" ");

        Arrays.sort(letters, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        StringBuilder str = new StringBuilder();
        for (String letter : letters) {

            str.append(letter).append(" ");
        }
        str.setCharAt(0, String.valueOf((str.charAt(0))).toUpperCase().toCharArray()[0]);

        return str.substring(0, str.length() - 1).toString();
    }

    public static void main(String[] args) {
        System.out.println(new s1451().arrangeWords("Keep calm and code on"));
    }
}