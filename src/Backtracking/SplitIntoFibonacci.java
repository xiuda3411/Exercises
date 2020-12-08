package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Exercises
 * @description: 将数组拆分成斐波那契数列
 * @author: 宋丽
 * @create: 2020-12-08 15:35
 **/
public class SplitIntoFibonacci {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        dfs(S.toCharArray(),0,res);
        return res;
    }
    private boolean dfs(char[] digit,int index,List<Integer> res){
        int len = digit.length;
        if(index == len && res.size() > 2){
            return true;
        }
        for(int i = index ; i < len ; i++){
            if(digit[index] == '0' && i > index){
                break;
            }
            long sum = 0;
            for(int j = index ; j <= i ; j++){
                sum = sum*10 + digit[j] - '0';
            }
            //超过32位整型直接broke；
            if(sum > Integer.MAX_VALUE){
                break;
            }
            if(res.size() > 1 && sum > res.get(res.size() - 1) + res.get(res.size() - 2)){
                break;
            }
            if(res.size() <= 1 || sum == res.get(res.size() - 1) + res.get(res.size() - 2)){
                res.add((int)sum);
                if(dfs(digit,i+1,res)){
                    return true;
                }
                res.remove(res.size() - 1);
            }
        }
        return false;
    }
}
