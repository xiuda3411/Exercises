package Math;

import java.util.Arrays;

/**
 * @program: Exercises
 * @description: 分发饼干
 * @author: 宋丽
 * @create: 2020-12-25 21:38
 **/
public class FindContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0,j = 0;
        int res = 0;
        while( i < g.length && j < s.length){
            if(g[i] <= s[j]){
                i++;
                j++;
                res++;
            }else{
                j++;
            }
        }
        return res;
    }
}
