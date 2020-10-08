package TreeAndMap;

import sun.reflect.generics.tree.Tree;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @program: Exercises
 * @description: 从前序与中序遍历序列构造二叉树
 * @author: 宋丽
 * @create: 2020-10-08 18:23
 **/
public class BuildTree {
    /**
     * 递归解法
     * 将前序与后序遍历分解成根结点、左子树、右子树的结构
     * @param preorder
     * @param inorder
     * @return
     */
    private Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;
        map = new HashMap<>(preLen);
        for (int i = 0 ; i < inLen ; i++){
            map.put(inorder[i],i);
        }
        return buildTree(preorder,0,preLen-1,map,0,inLen-1);
    }

    private TreeNode buildTree(int[] preorder, int preLeft, int preRight, Map<Integer, Integer> map, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight){
            return null;
        }
        int root = preorder[preLeft];
        TreeNode r = new TreeNode(root);

        int pIndex = map.get(root);
        r.left = buildTree(preorder,preLeft+1,pIndex-inLeft+preLeft,map,inLeft,pIndex-1);
        r.right = buildTree(preorder,pIndex-inLeft+preLeft+1,preRight,map,pIndex+1,inRight);
        return r;
    }

    /**
     * 迭代
     * 使用栈和中序遍历数组指针进行辅助
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0){
            return null;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        int inIndex = 0;
        for (int i = 1 ; i < preorder.length ; i++){
            int preVal = preorder[i];
            TreeNode t = stack.peek();
            if (t.val != inorder[inIndex]){
                t.left = new TreeNode(preVal);
                stack.push(t.left);
            }else {
                while ( !stack.isEmpty() && stack.peek().val == inorder[inIndex]){
                    t = stack.pop();
                    inIndex++;
                }
                t.right = new TreeNode(preVal);
                stack.push(t.right);
            }
        }
        return root;
    }
}
