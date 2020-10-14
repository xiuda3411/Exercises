package ArraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: Exercises
 * @description: 查找常用字符
 * @author: 宋丽
 * @create: 2020-10-14 10:17
 **/
public class CommonChars {
    /**
     * 我的解法
     * 时间太慢了，每次调用Sting的indexOf方法花的时间很多
     * @param A
     * @return
     */
    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        int len = A.length;
        if (len < 1){
            return res;
        }
        for (int i = 0; i < A[0].length(); i++) {
            boolean flag = true;
            char b = A[0].charAt(i);
            String B = Character.toString(b);
            for (int j = 0; j < A.length; j++) {
                int flag2 = A[j].indexOf(b);
                //该字符串中没有字符b
                if (flag2 == -1) {
                    flag = false;
                    break;
                //该字符串中有字符b
                }else {
                    A[j] = A[j].replaceFirst(B,"#");
                }
            }
            if (flag){
                res.add(B);
            }
        }
        return res;
    }

    /**
     * 官方解答
     * 很巧妙
     * @param A
     * @return
     */
    public List<String> commonChars2(String[] A) {
        int[] minfreq = new int[26];
        Arrays.fill(minfreq, Integer.MAX_VALUE);
        for (String word: A) {
            int[] freq = new int[26];
            int length = word.length();
            for (int i = 0; i < length; ++i) {
                char ch = word.charAt(i);
                ++freq[ch - 'a'];
            }
            for (int i = 0; i < 26; ++i) {
                minfreq[i] = Math.min(minfreq[i], freq[i]);
            }
        }

        List<String> ans = new ArrayList<String>();
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < minfreq[i]; ++j) {
                ans.add(String.valueOf((char) (i + 'a')));
            }
        }
        return ans;
    }
}
