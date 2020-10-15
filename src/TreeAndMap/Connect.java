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
        if (root == null) {
            return root;
        }

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size()>0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (i < size - 1) {
                    node.next = queue.peek();
                }
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

    /**
     * 用指针
     * @param root
     * @return
     */
    public Node connect2(Node root) {
        if (root == null) {
            return null;
        }
        // 使用已建立的 next 指针
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

    /**
     *
     * @param root
     * @return
     */
    public Node connect3(Node root) {
        if (root == null || root.left == null){
            return root;
        }
        root.left.next = root.right;
        root.right.next = root.next == null ? null : root.next.left;
        connect3(root.left);
        connect3(root.right);
        return root;
    }
}
