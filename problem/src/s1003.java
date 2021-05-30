import java.util.Stack;

/**
 * @author jianmiao.xu
 * @date 2021/5/27
 */
public class s1003 {
    public boolean isValid(String s) {
        int length = s.length();
        Stack<String> stack = new Stack<>();

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            str.append(c);

            while(str.toString().endsWith("abc")) {
                str.replace(str.length() - 3, str.length(), "");
            }
        }

        return str.length() == 0;
    }

    public static void main(String[] args) {
        System.out.println(new s1003().isValid("abccba"));
    }
}