/**
 * @program: Exercises
 * @description: 初级算法，数学类
 * @author: 宋丽
 * @create: 2020-09-23 18:55
 **/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 *
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 *
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 *
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xngt85/
 */
public class FizzBuzz {

    /**
     * 我的解答
     * @param n
     * @return
     *
     * 复杂度分析
     * 时间复杂度： O(N)
     * 空间复杂度： O(1)
     */
    public List<String> fizzBuzz(int n) {
        List<String> a = new ArrayList<>(n);
        for(int i = 1; i <= n; i++ ){
            if(i % 3 == 0 && i % 5 == 0){
                a.add("FizzBuzz");
            }else if(i % 3 == 0){
                a.add("Fizz");
            }else if(i % 5 == 0){
                a.add("Buzz");
            }else{
                a.add(String.valueOf(i));
            }
        }
        return a;
    }


    /**
     * 官方解答3
     * 使用散列表（哈希表）
     * 使用字符串拼接
     * 拥有更自由的映射关系，当要求复杂度增加后更易更改
     * @param n
     * @return
     */
    public List<String> fizzBuzz3(int n) {

        // ans list
        List<String> ans = new ArrayList<String>();

        // Hash map to store all fizzbuzz mappings.
        HashMap<Integer, String> fizzBizzDict =
                new HashMap<Integer, String>() {
                    {
                        put(3, "Fizz");
                        put(5, "Buzz");
                    }
                };

        for (int num = 1; num <= n; num++) {

            StringBuilder numAnsStr = new StringBuilder();

            for (Integer key : fizzBizzDict.keySet()) {

                // If the num is divisible by key,
                // then add the corresponding string mapping to current numAnsStr
                if (num % key == 0) {
                    numAnsStr.append(fizzBizzDict.get(key));
                }
            }

            if ("".equals(numAnsStr.toString())) {
                // Not divisible by 3 or 5, add the number
                numAnsStr.append(Integer.toString(num));
            }

            // Append the current answer str to the ans list
            ans.add(numAnsStr.toString());
        }

        return ans;
    }

    /**
     * 重写get和size方法
     * 在循环输出结果list时计算
     * @param n
     * @return
     */
    public List<String> fizzBuzz4(int n) {
        return (List<String>) new java.util.AbstractList<String>() {
            @Override
            public String get(int i) {
                ++i;
                switch((i%3==0?1:0)+(i%5==0?2:0)){
                    case 0:return String.valueOf(i);
                    case 1:return "Fizz";
                    case 2:return "Buzz";
                    case 3:return "FizzBuzz";
                }
                return "";
            }

            @Override
            public int size() {
                return n;
            }
        };
    }

}
