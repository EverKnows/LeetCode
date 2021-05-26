/**
 * @author jianmiao.xu
 * @date 2021/5/26
 */
public class s1190 {

    public String reverseParentheses(String s) {
        int length = s.length();
        if (length == 0 || length == 1) {
            return s;
        }

        int end = length - 1;
        StringBuilder newStr = new StringBuilder(s);

        for (int i = 0; i <= end; i++) {
            if (newStr.charAt(i) == '(') {
                end = findRKH(newStr, end);

                reverseStr(newStr, i, end);
            }

        }
        return newStr.toString().replace("(", "").replace(")", "");

    }

    private void reverseStr(StringBuilder str, int start, int end) {

        StringBuilder temp = new StringBuilder();
        for (int i = end; i >= start; i--) {
            if (str.charAt(i) == '(') {
                temp.append(")");
            } else if(str.charAt(i) == ')'){
                temp.append("(");
            } else {
                temp.append(str.charAt(i));
            }

        }

        str.replace(start, end + 1, temp.toString());
    }

    private int findRKH(StringBuilder s, int end) {
        for (int i = end; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new s1190().reverseParentheses("a(bcdefghijkl(mno)p)q"));

        //StringBuilder str = new StringBuilder("123456");



        //System.out.println(str.substring(2 ,4));

    }
}