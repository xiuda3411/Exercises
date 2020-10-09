package TreeAndMap;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @program: Exercises
 * @description: 二叉搜索树中第k小的元素
 * @author: 宋丽
 * @create: 2020-10-09 13:21
 **/
public class KthSmallest {
    /**
     * (二叉查找树)BST的中序遍历按升序排列
     * 迭代遍历结果
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> arrayList = inorder(root,new ArrayList<Integer>());
        return arrayList.get(k-1);
    }

    private ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> list) {
        if (root == null){
            return list;
        }
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
        return list;
    }

    /**
     * 迭代
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest2(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();

        while (true){
            while (root != null){
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if (--k == 0){
                return root.val;
            }
            root = root.right;
        }
    }
}
