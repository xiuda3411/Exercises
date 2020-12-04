package ArraysAndStrings;

/**
 * @program: Exercises
 * @description: 分割数组为连续子序列
 * @author: 宋丽
 * @create: 2020-12-04 10:12
 **/
public class IsPossible {
    /**
     * 贪心算法
     * @param nums
     * @return
     */
    public boolean isPossible(int[] nums) {
        int len = nums.length;
        if(len < 3){
            return false;
        }
        //辅助数组的长度
        int ncLen = nums[len - 1] - nums[0] + 1;
        //记录数字的出现次数
        int[] nc = new int[ncLen];
        for (int num : nums) {
            nc[num - nums[0]]++;
        }
        //记录连续子序列的尾巴
        int[] tail = new int[ncLen];

        for(int i = 0 ; i < ncLen ; i++){
            if(nc[i] == 0){
                continue;
            }
            if(nc[i] < 0){
                return false;
            }
            if(nc[i] > 0){
                //当前数字的前一个有尾巴存在，将当前数字续在尾巴上
                if(i > 0 && tail[i - 1] > 0){
                    tail[i - 1]--;
                    tail[i]++;
                    nc[i]--;
                }else{
                    //当前数字后面至少存在两个连续数字
                    if(i + 2 < ncLen){
                        nc[i]--;
                        nc[i + 1]--;
                        nc[i + 2]--;
                        tail[i + 2]++;
                    }else{
                        return false;
                    }
                }
                //将当前的数字的出现次数消耗完再检测下一个数字
                i--;
            }
        }
        return true;
    }
}
