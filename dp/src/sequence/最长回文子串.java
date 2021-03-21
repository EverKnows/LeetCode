package sequence;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author jianmiao.xu
 * @date 2021/3/17
 */
public class 最长回文子串 {
    public String longestPalindrome(String s) {
        int len = s.length();
        int max = 1;

        for (int i = 1; i < len; i++) {

        }
        return "";
    }

    public boolean isPalindrome(String str, int l, int r) {
        while(l < r) {
            if (str.charAt(l) == str.charAt(r)) {
                l++;
                r--;
            } else {
                return false;
            }
            
        }

        return true;
    }
}