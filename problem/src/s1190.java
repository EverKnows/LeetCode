import java.util.Stack;

/**
 * @author jianmiao.xu
 * @date 2021/5/26
 */
public class s1190 {

    public String reverseParentheses(String s) {
        int length = s.length();

        Stack<String> stack = new Stack<>();
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ')') {
                str.reverse();
                str.insert(0, stack.pop());
            } else if (c == '(') {
                stack.push(str.toString());
                str = new StringBuilder();
            } else {
                str.append(c);
            }
        }

        return str.toString();
    }


    public static void main(String[] args) {
        System.out.println(new s1190().reverseParentheses("a(bcdefghijkl(mno)p)q"));

        //StringBuilder str = new StringBuilder("123456");



        //System.out.println(str.substring(2 ,4));

    }
}