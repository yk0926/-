package com.kyong.suixianglu.b链表;

/**
 * @author kyong
 * @date 2023/4/10 11:53
 */
public class c反转链表 {
    public ListNode reverseList(ListNode head) {
        ListNode temp = null;
        ListNode pre = null;
        ListNode cur  = head;
        while (cur!=null){
            temp = cur.next;//保存下一个节点
            cur.next = pre;
            pre =cur;
            cur = temp;
        }
        return pre;
        /**
         * ListNode temp ;
         *         ListNode pre ;
         *         ListNode cur ;
         *         if(head.next == null)
         *             return head;
         *         cur = head;
         *         pre = null;
         *         while (cur.next!=null){
         *             temp = cur.next;
         *             cur.next = pre;
         *             pre =cur;
         *             cur = temp;
         *         }
         *         return cur;
         */
    }

    //递归
    ListNode reverseList2(ListNode head) {
        // 边缘条件判断
        if(head == null) return null;
        if (head.next == null) return head;

        // 递归调用，翻转第二个节点开始往后的链表
        ListNode last = reverseList2(head.next);
        // 翻转头节点与第二个节点的指向
        head.next.next = head;
        // 此时的 head 节点为尾节点，next 需要指向 NULL
        head.next = null;
        return last;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
