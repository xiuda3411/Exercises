package ArraysAndStrings;

import java.util.*;

/**
 * @program: Exercises
 * @description: 字母异位词分组
 * @author: 宋丽
 * @create: 2020-09-28 18:24
 **/
public class GroupAnagrams {
    /**
     * 用map，将排序后的字符串作为key
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (String s:strs) {
            char[] a = s.toCharArray();
            Arrays.sort(a);
            String key = String.valueOf(a);
            if (!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}