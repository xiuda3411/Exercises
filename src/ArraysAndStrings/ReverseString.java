package ArraysAndStrings;

/**
 * @program: Exercises
 * @description: 反转字符串
 * @author: 宋丽
 * @create: 2020-10-08 13:29
 **/
public class ReverseString {
    /**
     * 我的方法
     * 也可以用双指针
     * @param s
     */
    public void reverseString(char[] s) {
        int len = s.length;
        for(int i = 0 ; i < len/2 ; i++){
            char temp = s[i];
            s[i] = s[len-1-i];
            s[len-1-i] = temp;
        }
    }
}
