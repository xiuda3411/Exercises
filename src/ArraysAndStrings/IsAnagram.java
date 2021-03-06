package ArraysAndStrings;

/**
 * @program: Exercises
 * @description: 有效的字母异位词
 * @author: 宋丽
 * @create: 2020-11-22 19:09
 **/
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] count = new int[26];
        for(char ch : s.toCharArray()){
            count[ch - 'a']++;
        }
        for(char ch : t.toCharArray()){
            count[ch - 'a']--;
            if(count[ch - 'a'] < 0){
                return false;
            }
        }
        return true;
    }
}
