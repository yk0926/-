package com.kyong.suixianglu.b链表;

/**
 * @author kyong
 * @date 2023/4/14 11:17
 */
//19.删除链表的倒数第N个节点
public class e删除链表的倒数第N个节点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode newHead = new ListNode(-1,head);
        ListNode fast = newHead;
        ListNode slow = newHead;
        for(int i = 0; i<n ; i++){
            fast = fast.next;
        }
        while(fast.next!= null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return newHead.next;
    }
}
