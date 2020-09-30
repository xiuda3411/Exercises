package ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: Exercises
 * @description: 最长回文子串
 * @author: 宋丽
 * @create: 2020-09-29 21:52
 **/
public class LongestPalindrome {

    /**
     * 暴力求解法
     * 对每个大于等于2的子串进行是否回文判断
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {

        char[] chars = s.toCharArray();
        int len = s.length();
        //最长回文子串的长度
        int maxLen = 1;
        //最长回文子串的起始位置
        int begin = 0;

        if (len < 2){
            return s;
        }
        for (int i = 0 ; i < len-1 ; i++){
            for (int j = i+1 ; j < len ; j++){
                if (j - i +1 > maxLen && isPalindrome(chars,i,j)){
                    maxLen = j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }

    private boolean isPalindrome(char[] chars,int left,int right){
        while (left < right){
            if (chars[left] == chars[right]){
                left--;
                right++;
            }else {
                return false;
            }
        }
        return true;
    }

    /**
     * 动态规划法
     * 从上到下填写dp表，填写顺序很重要，左下角先
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[len][len];
        //最长回文子串的长度
        int maxLen = 1;
        //最长回文子串的起始位置
        int begin = 0;

        if (len < 2){
            return s;
        }

        for (int j = 1 ; j < len ; j++){
            for (int i = 0 ; i < j ; i++){
                if (chars[i] != chars[j]){
                    dp[i][j] = false;
                }else {
                    if (j-i < 3){
                        dp[i][j] = true;
                    }else {
                        //检测到端点i，j字符相等，长度超过3，赋值为i-1,j-1的判断结果
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                if (dp[i][j] && j-i+1 > maxLen){
                    maxLen = j-i+1;
                    begin = i;
                }
            }
        }

        return s.substring(begin,begin+maxLen);
    }


}
