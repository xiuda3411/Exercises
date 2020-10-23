package LinkedList;

/**
 * @program: Exercises
 * @description: 回文链表
 * @author: 宋丽
 * @create: 2020-10-23 19:40
 **/
public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        //寻找链表中点
        ListNode mid = mid(head);
        System.out.println(mid.val);
        //将链表翻转
        ListNode reverse = mid.next;
        mid.next = null;
        reverse = reverse(reverse);
        //比较翻转后的链表和原链表是否相等
        while (head != null && reverse != null){
            if (head.val != reverse.val){
                return false;
            }
            head = head.next;
            reverse = reverse.next;
        }
        return true;
    }

    private ListNode mid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null){
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }

}
