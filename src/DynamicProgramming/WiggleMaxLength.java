package DynamicProgramming;

/**
 * @program: Exercises
 * @description: 摆动序列
 * @author: 宋丽
 * @create: 2020-12-12 21:01
 **/
public class WiggleMaxLength {
    /**
     * 贪心算法
     * @param nums
     * @return
     */
    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        if(len < 2){
            return len;
        }
        //前一个差值
        int preDif = nums[1] - nums[0];
        //返回值，如果前两个值相等则取1，不然取2
        int res = preDif == 0 ? 1 : 2;
        for(int i = 1 ; i < len - 1 ; i++){
            //循环计算下一个差值
            int dif = nums[i + 1] - nums[i];
            //如果为0，跳过本次循环
            if(dif == 0){
                continue;
            }
            //如果上一个差值为0，或者前后两个差值摇摆，返回值+1
            //这里preDif == 0 的情况最多只会出现一次，例如[1,1,2]
            if(preDif == 0 || dif * preDif < 0){
                res++;
            }
            //此处dif != 0,所以之后的preDif != 0
            preDif = dif;
        }
        return res;
    }

    /**
     * 动态规划
     * 一种状态，优化存储，分别使用一个变量来表示
     * @param nums
     * @return
     */
    public int wiggleMaxLength2(int[] nums) {
        int down = 1, up = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1])
                up = down + 1;
            else if (nums[i] < nums[i - 1])
                down = up + 1;
        }
        return nums.length == 0 ? 0 : Math.max(down, up);
    }
}
