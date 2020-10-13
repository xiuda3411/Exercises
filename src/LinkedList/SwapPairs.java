package LinkedList;

/**
 * @program: Exercises
 * @description: 两两交换链表中的结点
 * @author: 宋丽
 * @create: 2020-10-13 15:50
 **/
public class SwapPairs {
    /**
     * 迭代 交换后用上一结点进行连接
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode a = new ListNode(0);
        a.next = head;
        change(a,head);
        return a.next;
    }

    private void change(ListNode pre,ListNode head){
        if(head == null || head.next == null){
            return;
        }
        ListNode a = head;
        ListNode b = head.next;
        a.next = b.next;
        b.next = a;
        head = b;
        pre.next = head;
        change(head.next,head.next.next);
    }
}
