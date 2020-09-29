package ArraysAndStrings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @program: Exercises
 * @description: 无重复字符的最长子串
 * @author: 宋丽
 * @create: 2020-09-29 19:38
 **/
public class LengthOfLongestSubstring {
    /**
     * 我的方法
     * 用set储存子串，用max储存最长字串的长度
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int temp = 0;
        Set<Character> set = new HashSet<>();
        char[] a = s.toCharArray();
        for (int i = 0 ; i < a.length ; i++){
            if (set.contains(a[i])){
                i -= set.size()-1;
                set.clear();
                temp = 0;
            }
            set.add(a[i]);
            temp++;
            if (temp>max){
                max = temp;
            }
        }
        return max;
    }

    /**
     * 滑动窗口法
     * 使用map记录字符和对应下标
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        int max = 0;
        int start = 0;
        int end = 0;
        Map<Character,Integer> map = new HashMap<>();
        char[] a = s.toCharArray();
        while (end < s.length()){
            if (map.containsKey(a[end]) && start < map.get(a[end])){
                start = map.get(a[end])+1;
            }
            map.put(a[end],end);
            end++;
            max = Math.max(max,end-start);
        }
        return max;
//        //官方使用set
//        // 哈希集合，记录每个字符是否出现过
//        Set<Character> occ = new HashSet<Character>();
//        int n = s.length();
//        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
//        int rk = -1, ans = 0;
//        for (int i = 0; i < n; ++i) {
//            if (i != 0) {
//                // 左指针向右移动一格，移除一个字符
//                occ.remove(s.charAt(i - 1));
//            }
//            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
//                // 不断地移动右指针
//                occ.add(s.charAt(rk + 1));
//                ++rk;
//            }
//            // 第 i 到 rk 个字符是一个极长的无重复字符子串
//            ans = Math.max(ans, rk - i + 1);
//        }
//        return ans;
    }
}
