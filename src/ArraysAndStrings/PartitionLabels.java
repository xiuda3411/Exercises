package ArraysAndStrings;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Exercises
 * @description: 划分字母区间
 * @author: 宋丽
 * @create: 2020-10-22 22:44
 **/
public class PartitionLabels {
    /**
     * 贪心算法+双指针
     * @param S
     * @return
     */
    public List<Integer> partitionLabels(String S) {
        int len = S.length();
        int[] last = new int[26];
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < len ; i++){
            last[S.charAt(i) - 'a'] = i;
        }
        int start = 0;
        int end = 0;
        for(int i = 0 ; i < len ; i++){
            end = Math.max(end,last[S.charAt(i) - 'a']);
            if (i == end){
                list.add(end - start + 1);
                start = end + 1;
            }
        }
        return list;
    }
}
