package ArraysAndStrings;

import java.util.Arrays;

/**
 * @program: Exercises
 * @description:具有给定数值的最小字符串
 * @author: 宋丽
 * @create: 2020-11-22 11:26
 **/
public class GetSmallestString {
    public String getSmallestString(int n, int k) {
        char[] res = new char[n];
        for(int i = 0; i < n; i++){
            res[i] = 'a';
        }
        int count = n;
        for(int i = n - 1 ; i >= 0 ; i--){
            if(k == count){
                break;
            }else{
                if(k < count + 25){
                    int t = 0;
                    res[i] = (char)(k - count + 97);
                    break;
                }else{
                    res[i] = 'z';
                    count =+ 25;
                }
            }
        }
        return new String(res);
    }
}
