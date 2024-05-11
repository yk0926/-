package com.kyong.suixianglu.linkedLsit;

/**
 * @author kyong
 * @date 2023/4/10 18:20
 */
//24.两两交换链表中的节点
public class d两两交换链表中的节点 {
    public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode cur = newHead;
        ListNode first;
        ListNode second;
        ListNode temp;
        while (cur.next!=null && cur.next.next!=null){
            first = cur.next;
            second = cur.next.next;
            temp = cur.next.next.next;
            cur.next = second;
            second.next = first;
            first.next = temp;
            cur = first;
        }
        return newHead.next;
    }

    //递归
    public ListNode swapPairs2(ListNode head) {
        public ListNode swapPairs(ListNode head) {
            // base case 退出提交
            if(head == null || head.next == null) return head;
            // 获取当前节点的下一个节点
            ListNode next = head.next;
            // 进行递归
            ListNode newNode = swapPairs(next.next);
            // 这里进行交换
            next.next = head;
            head.next = newNode;
            return next;
        }
    }
}
