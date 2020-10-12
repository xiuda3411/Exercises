package TreeAndMap;

/**
 * @program: Exercises
 * @description: 二叉搜索树的最小绝对差
 * @author: 宋丽
 * @create: 2020-10-12 12:11
 **/
public class GetMinimumDifference {
    int pre = 0;
    int ans = 0;
    public int getMinimumDifference(TreeNode root) {
        pre = -1;
        ans = Integer.MAX_VALUE;
        minDiffer(root);
        return ans;
    }

    private void minDiffer(TreeNode root) {
        if (root == null){
            return;
        }
        minDiffer(root.left);
        if (pre == -1){
            pre = root.val;
        }else {
            ans = Math.min(ans,root.val-pre);
            pre = root.val;
        }
        minDiffer(root.right);
    }
}
