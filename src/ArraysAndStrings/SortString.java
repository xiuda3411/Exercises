package ArraysAndStrings;

/**
 * @program: Exercises
 * @description: 上升下降字符串
 * @author: 宋丽
 * @create: 2020-11-25 17:12
 **/
public class SortString {
    /**
     * 字母桶
     * @param s
     * @return
     */
    public String sortString(String s) {
        int len = s.length();
        int[] count = new int[len];
        for(char c : s.toCharArray()){
            count[c - 'a']++;
        }
        StringBuilder res = new StringBuilder();
        while (res.length() != len){
            for (int i = 0; i < len; i++) {
                if(count[i] > 0){
                    char c = (char)(i + 'a');
                    res.append(c);
                    count[i]--;
                }
            }
            for (int i = len - 1; i >= 0 ; i--) {
                if(count[i] > 0){
                    char c = (char)(i + 'a');
                    res.append(c);
                    count[i]--;
                }
            }
        }
        return res.toString();
    }
}
