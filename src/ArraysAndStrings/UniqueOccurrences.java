package ArraysAndStrings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: Exercises
 * @description: 独一无二的出现次数
 * @author: 宋丽
 * @create: 2020-10-28 10:03
 **/
public class UniqueOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        int len = arr.length;
        if(len < 2){
            return true;
        }
        Set<Integer> times = new HashSet<>();
        Arrays.sort(arr);
        int pre = -1;
        for(int i = 0 ; i < len ; i++){
            if(i + 1 == len || arr[i] != arr[i + 1] ){
                if(!times.contains(i - pre)){
                    times.add(i - pre);
                    pre = i;
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}
