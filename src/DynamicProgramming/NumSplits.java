package DynamicProgramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: Exercises
 * @description: 字符串的好分割数目
 * @author: 宋丽
 * @create: 2020-11-02 16:37
 **/
public class NumSplits {
    /**
     * 动态规划
     * 从左边和右边分别数出不同字符个数并记录
     * 两个数组下标差1的位置进行分割，如果值相等则为好分割
     * @param s
     * @return
     */
    public int numSplits(String s) {
        int n = s.length();
        int[] left = new int[n + 2];
        int[] right = new int[n + 2];
        boolean[] recLeft = new boolean[26];
        boolean[] recRight = new boolean[26];
        for (int i = 1; i <= n; i++) {
            int c = s.charAt(i - 1) - 'a';
            if (recLeft[c]) {
                left[i] = left[i - 1];
            } else {
                recLeft[c] = true;;
                left[i] = left[i - 1] + 1;
            }
        }
        for (int i = n; i > 0; i--) {
            int c = s.charAt(i - 1) - 'a';
            if (recRight[c]) {
                right[i] = right[i + 1];
            } else {
                recRight[c] = true;
                right[i] = right[i + 1] + 1;
            }
        }
        int ret = 0;
        for (int i = 1; i < n; i++) {
            if (left[i] == right[i + 1]) {
                ret++;
            }
        }
        return ret;
    }

    /**
     * 简写动态规划
     * @param s
     * @return
     */
    public int numSplits2(String s) {
        int n = s.length(), count = 0;
        int[] left = new int[256], right = new int[256];
        for(char c : s.toCharArray()) {
            System.out.println(right[c]);
            if(right[c]++ == 0) {
                count++;
            }
        }
        int res = 0, l = 0, r = count;
        for(int i = 0; i < n - 1; i++) {
            char c = s.charAt(i);
            if(left[c]++ == 0) l++;
            if(--right[c] == 0) r--;
            if(l == r) res++;
        }
        return res;
    }
}
