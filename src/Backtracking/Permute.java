package Backtracking;

import java.util.*;

/**
 * @program: Exercises
 * @description: 全排列
 * @author: 宋丽
 * @create: 2020-10-11 19:12
 **/
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new LinkedList<>();
        if (len == 0){
            return res;
        }
        Deque<Integer> path = new ArrayDeque<Integer>();
        boolean[] used = new boolean[len];
        dfs(nums,len,0,path,used,res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth, Deque<Integer> path,boolean[] used,List<List<Integer>> res) {
        if (len == depth){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]){
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, len, depth+1, path, used, res);
            path.removeLast();
            used[i] = false;
        }
    }
}
