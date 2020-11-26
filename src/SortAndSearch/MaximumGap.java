package SortAndSearch;

/**
 * @program: Exercises
 * @description: 最大间距
 * @author: 宋丽
 * @create: 2020-11-26 20:36
 **/
public class MaximumGap {
    /**
     * 桶排序
     * @param nums
     * @return
     */
    public int maximumGap(int[] nums) {
        int len = nums.length;
        if(len < 2){
            return 0;
        }
        //找出最大值和最小值
        int min = nums[0];
        int max = nums[0];
        for(int i : nums){
            max = Math.max(max,i);
            min = Math.min(min,i);
        }
        //计算桶的尺寸
        int size = Math.max(1,(max - min)/(len - 1));
        //计算桶的个数
        int count = (max - min)/size + 1;
        //[i][0]记录最小值，[i][1]记录最大值
        int[][] bucket = new int[count][2];
        for(int[] i : bucket){
            i[0] = max + 1;
            i[1] = min - 1;
        }
        for(int i : nums){
            int index = (i - min)/size;
            bucket[index][0] = Math.min(bucket[index][0],i);
            bucket[index][1] = Math.max(bucket[index][1],i);
        }
        int res = 0;
        int pre = bucket[0][1];
        //返回值是当前桶的最小值-上一个桶的最大值 的最大差值
        for(int i = 1 ; i < count ; i++){
            if(bucket[i][0] != max + 1){
                res = Math.max(res,bucket[i][0] - pre);
                pre = bucket[i][1];
            }
        }
        return res;
    }
}
