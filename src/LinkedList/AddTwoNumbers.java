package LinkedList;

/**
 * @program: Exercises
 * @description: 两数相加
 * @author: 宋丽
 * @create: 2020-10-2 20:12
 **/
public class AddTwoNumbers {
    /**
     * 中规中矩
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1,q = l2,current =  dummyHead;
        int carry = 0;
        while (p != null || q != null){
            int x = (p != null)? p.val:0;
            int y = (q != null)? q.val:0;
            int sum = carry + x + y;
            carry = sum/10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (p != null){
                p = p.next;
            }
            if (q != null){
                q = q.next;
            }
        }
        if (carry > 0){
            current.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
