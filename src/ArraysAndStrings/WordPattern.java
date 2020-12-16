package ArraysAndStrings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @program: Exercises
 * @description: 单词规律
 * @author: 宋丽
 * @create: 2020-12-16 18:32
 **/
public class WordPattern {
    /**
     * hashmap+hashset
     * @param pattern
     * @param s
     * @return
     */
    public boolean wordPattern(String pattern, String s) {
        String[] ss = s.split(" ");
        if(pattern.length() != ss.length){
            return false;
        }
        Map<Character,String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        int i = 0;
        for(char c : pattern.toCharArray()){
            if(map.containsKey(c)){
                if(!map.get(c).equals(ss[i])){
                    return false;
                }
            }else if(set.add(ss[i])){
                map.put(c,ss[i]);
            }else{
                return false;
            }
            i++;
        }
        return true;
    }

    /**
     * 单map，利用put返回值为上一个value的特性
     * @param pattern
     * @param s
     * @return
     */
    public boolean wordPattern2(String pattern, String s) {
        String[] ss = s.split(" ");
        if(pattern.length() != ss.length){
            return false;
        }
        Map map = new HashMap<>();
        int i = 0;
        for(char c : pattern.toCharArray()){
            if(map.put(c,i) != map.put(ss[i],i)){
                return false;
            }
            i++;
        }
        return true;
    }
}
