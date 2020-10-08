package TreeAndMap;

import java.util.*;

/**
 * @program: Exercises
 * @description: 锯齿形层次遍历
 * @author: 宋丽
 * @create: 2020-10-08 13:45
 **/
public class ZigzagLevelOrder {
    /**
     * 我的方法
     * 使用队列进行层次遍历
     * 用一个布尔值常量代表层，true正向，false反向
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            LinkedList<TreeNode> nextqueue = new LinkedList<>();
            if (!flag){
                //正 从左往右
                flag = !flag;
                while (!queue.isEmpty()){
                    //弹出队列中第一个元素
                    TreeNode t =  queue.pop();
                    if (t != null){
                        list.add(t.val);
                        System.out.println("true+"+t.val);
                        nextqueue.add(t.left);
                        nextqueue.add(t.right);
                    }
                }
            }else {
                //反 从右往左
                flag = !flag;
                while (!queue.isEmpty()){
                    TreeNode t =  queue.removeLast();
                    if (t != null){
                        list.add(t.val);
                        System.out.println("false+"+t.val);
                        nextqueue.push(t.right);
                        nextqueue.push(t.left);
                    }
                }
            }
            if (list.size() != 0){
                lists.add(list);
            }
            queue = nextqueue;
        }
        return lists;
    }
}
