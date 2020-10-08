package TreeAndMap;

/**
 * @program: Exercises
 * @description: 二叉树结点
 * @author: 宋丽
 * @create: 2020-10-07 20:15
 **/
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
