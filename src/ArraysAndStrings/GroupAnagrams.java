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

    /**
     * 用map记录字母异位词
     * 也可以用质数表示26个字母，把每个字母相乘可保证字母异位词的乘积必定是相等的
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> res = new LinkedList<>();
        Map<String,Integer> map = new HashMap<>(strs.length);
        int k = 0;
        for(String s : strs){
            int[] counts = new int[26];
            for(char c : s.toCharArray()){
                counts[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < 26 ; i++){
                if(counts[i] != 0){
                    sb.append(i + 'a');
                    sb.append(counts[i]);
                }
            }
            if(!map.containsKey(sb.toString())){
                res.add(new LinkedList<String>(){{
                    add(s);
                }});
                map.put(sb.toString(),k++);
            }else{
                res.get(map.get(sb.toString())).add(s);
            }
        }
        return res;
    }
}