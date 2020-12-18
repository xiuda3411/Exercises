package Math;

/**
 * @program: Exercises
 * @description: 只出现一次的数字，只出现一次的数字2，只出现一次的数字3，找不同，寻找重复数，丢失的数字
 * @author: 宋丽
 * @create: 2020-12-18 10:39
 **/
public class SingleNumber {
    /**
     * 只出现一次的数字
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     *
     * 示例 1:
     * 输入: [2,2,1]
     * 输出: 1
     *
     * 示例 2:
     * 输入: [4,1,2,1,2]
     * 输出: 4
     *
     * 位运算
     * ^异或运算，位相同为1，否则为0
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i : nums){
            res ^= i;
        }
        return res;
    }

    /**
     * 只出现一次的数字2
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
     * 输入: [2,2,3,2]
     * 输出: 3
     *
     * 输入: [0,1,0,1,0,1,99]
     * 输出: 99
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        int a = 0;
        int b = 0;
        for(int i : nums){
            a = (a ^ i) & ~b;
            b = (b ^ i) & ~a;
        }
        return a;
    }

    /**
     * 找不同
     * 给定两个字符串 s 和 t，它们只包含小写字母。
     *
     * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
     *
     * 请找出在 t 中被添加的字母。
     * 输入：s = "abcd", t = "abcde"
     * 输出："e"
     * 解释：'e' 是那个被添加的字母。
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {
        int res = 0;
        for(char c : s.toCharArray()){
            res ^= c;
        }
        for(char c : t.toCharArray()){
            res ^= c;
        }
        return (char)res;
    }
}
