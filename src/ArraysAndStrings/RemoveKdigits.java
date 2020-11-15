package ArraysAndStrings;

/**
 * @program: Exercises
 * @description: 移掉K位数字
 * @author: 宋丽
 * @create: 2020-11-15 14:45
 **/
public class RemoveKdigits {
    /**
     * 从左到右，找第一个比后面大的字符，删除，清零，k次扫描。
     * @param num
     * @param k
     * @return
     */
    public String removeKdigits(String num, int k) {
        if(num.length() == k){
            return "0";
        }
        StringBuilder s = new StringBuilder(num);
        for(int i = 0 ; i < k ; i++){
            int index = 0;
            for(int j = 1 ; j < s.length() && s.charAt(j) >= s.charAt(j - 1) ; j++){
                index = j;
            }
            s.delete(index,index + 1);
            while(s.length() > 1 && s.charAt(0) == '0'){
                s.delete(0,1);
            }
        }
        return s.toString();
    }
}
