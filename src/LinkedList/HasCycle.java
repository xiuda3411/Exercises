package LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: Exercises
 * @description: 环形链表
 * @author: 宋丽
 * @create: 2020-10-09 19:20
 **/
public class HasCycle {
    /**
     * 快慢指针
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
//        ListNode p1 = head;
//        ListNode p2 = head;
//        while (p1 != null){
//            p1 = p1.next;
//            if (p2 == null){
//                return false;
//            }
//            if (p2.next == null){
//                return false;
//            }
//            p2 = p2.next.next;
//            if (p1 == p2){
//                return true;
//            }
//        }
//        return false;
        if(head == null || head.next == null){
            return false;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        while ( p1 != p2){
            if (p2 == null || p2.next == null){
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    /**
     * 哈希表记录结点地址，遍历所有结点进行对比
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        Set<ListNode> seen = new HashSet<ListNode>();
        while (head != null) {
            if (!seen.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
