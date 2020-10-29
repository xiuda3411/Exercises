package TreeAndMap;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: Exercises
 * @description: 求根到叶子节点数字之和
 * @author: 宋丽
 * @create: 2020-10-29 21:47
 **/
public class SumNumbers {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<Integer> numQueue = new LinkedList<Integer>();
        nodeQueue.offer(root);
        numQueue.offer(root.val);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int num = numQueue.poll();
            TreeNode left = node.left, right = node.right;
            if (left == null && right == null) {
                sum += num;
            } else {
                if (left != null) {
                    nodeQueue.offer(left);
                    numQueue.offer(num * 10 + left.val);
                }
                if (right != null) {
                    nodeQueue.offer(right);
                    numQueue.offer(num * 10 + right.val);
                }
            }
        }
        return sum;
    }
//    public int sumNumbers(TreeNode root) {
//        int flag = 0;
//        int sum = 0;
//        LinkedList<TreeNode> stake = new LinkedList<>();
//        if(root == null){
//            return 0;
//        }
//        stake.push(root);
//        while(!stake.isEmpty()){
//            TreeNode temp = stake.peek();
//            if(temp.left == null && temp.right == null){
//                int c = 1;
//                for(TreeNode t:stake){
//                    sum += t.val*c;
//                    c *= 10;
//                }
//                while (stake.getFirst().right == null && flag == 0 ){
//                    if (stake.size() == 1){
//                        flag = 1;
//                    }
//                    if (stake.isEmpty()){
//                        return sum;
//                    }
//                    stake.removeFirst();
//                }
//                stake.push(stake.getFirst().right);
//
//            }
//            while (temp.left != null){
//                stake.push(temp.left);
//                temp = temp.left;
//            }
//        }
//        return sum;
//    }
}
