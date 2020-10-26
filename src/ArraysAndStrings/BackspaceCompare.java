package ArraysAndStrings;

import java.util.*;

/**
 * @program: Exercises
 * @description: 比较含退格的字符串
 * @author: 宋丽
 * @create: 2020-10-19 10:11
 **/
public class BackspaceCompare {
    /**
     * 用栈完成
     *
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompare(String S, String T) {
        S = help(S);
        T = help(T);
        return S.equals(T);
    }

    private String help(String s) {
        int i = 0;
        LinkedList<Character> list = new LinkedList<>();
        while (i < s.length()) {
            if (s.charAt(i) == '#') {
                if (!list.isEmpty()) {
                    list.removeLast();
                }
            } else {
                list.addLast(s.charAt(i));
            }
            i++;
        }
        return list.toString();
    }

    /**
     * 双指针法
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompare2(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
            } else {
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }
}