package TreeAndMap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: Exercises
 * @description: 填充每个结点的下一个右侧结点指针
 * @author: 宋丽
 * @create: 2020-10-08 20:30
 **/
public class Connect {
    /**
     * 我的解法
     * 层次循环的基础上进行指针操作
     * @param root
     * @return
     */
    public Node connect(Node root) {
        List<List<Integer>> lists = new ArrayList<>();
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            LinkedList<Node> nextqueue = new LinkedList<>();
                while (!queue.isEmpty()){
                    //弹出队列中第一个元素
                    Node t =  queue.pop();
                    //如果第一个元素不为空
                    if (t != null){
                        if (!queue.isEmpty()){
                            t.next = queue.peek();
                        }else {
                            t.next = null;
                        }
                        nextqueue.add(t.left);
                        nextqueue.add(t.right);
                    }
                }
            queue = nextqueue;
        }
        return root;
    }

    public Node connect2(Node root) {
        if (root == null) {
            return null;
        }
        // 使用已建立的 n44ext 指针
        Node currLeftMost = root;
        Node curr = null;

        while (currLeftMost.left != null) {
            curr = currLeftMost;
            while (curr != null) {
                curr.left.next = curr.right;
                if (curr.next != null) {
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            currLeftMost = currLeftMost.left;
        }

        return root;
    }

}
