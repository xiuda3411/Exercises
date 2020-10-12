package Backtracking;

import java.util.*;

/**
 * @program: Exercises
 * @description: 子集
 * @author: 宋丽
 * @create: 2020-10-12 18:17
 **/
public class Subsets {
    /**
     * 迭代回溯
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0){
            return new ArrayList<>(res);
        }
        Deque<Integer> path = new ArrayDeque<Integer>();
        dfs(nums,0,path,res);
        return res;
    }

    private void dfs(int[] nums, int i, Deque<Integer> path, List<List<Integer>> res) {
        if (nums.length == i){
            res.add(new ArrayList<>(path));
            return;
        }
        //添加下一数字
        path.addLast(nums[i]);
        dfs(nums, i+1, path, res);
        //跳过下一数字
        path.removeLast();
        dfs(nums, i+1, path, res);
    }


}
