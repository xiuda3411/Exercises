package LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: Exercises
 * @description: 环形链表2
 * @author: 宋丽
 * @create: 2020-10-10 20:02
 **/
public class DetectCycle {
    /**
     * 哈希表
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null){
            if (set.contains(head)){
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }

    /**
     * 快慢指针
     * 利用快慢指针相遇后，慢指针与头指针接着移动总会在入环点相遇的数学特性来解决问题
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
