package TreeAndMap;

/**
 * @program: Exercises
 * @description: 完全二叉树的结点个数
 * @author: 宋丽
 * @create: 2020-11-24 19:40
 **/
public class CountNodes {
    /**
     * 二分法
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        TreeNode node = root;
        while (node.left != null) {
            level++;
            node = node.left;
        }
        int low = 1 << level, high = (1 << (level + 1)) - 1;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (exists(root, level, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public boolean exists(TreeNode root, int level, int k) {
        int bits = 1 << (level - 1);
        TreeNode node = root;
        while (node != null && bits > 0) {
            if ((bits & k) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            bits >>= 1;
        }
        return node != null;
    }

    /**
     * 巧妙的迭代
     * @param root
     * @return
     */
    public int countNodes2(TreeNode root) {
        if (root == null){
            return 0;
        }
        int rightDepth = getDepth(root.right);
        int leftDepth = getDepth(root.left);
        if (rightDepth == leftDepth){
            return (1 << rightDepth) + countNodes2(root.right);
        }else {
            return (1 << rightDepth) + countNodes2(root.left);
        }
    }

    private int getDepth(TreeNode right) {
        TreeNode node = right;
        int depth = 0;
        while (node != null){
            depth++;
            node = node.left;
        }
        return depth;
    }
}
