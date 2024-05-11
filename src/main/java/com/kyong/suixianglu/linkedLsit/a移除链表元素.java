package com.kyong.suixianglu.linkedLsit;

/**
 * @author kyong
 * @date 2023/3/27 17:27
 */
//203.移除链表元素

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class a移除链表元素 {

    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        while (head.val==val){
            if(head.next!=null){
                head = head.next;
            }else{
                return new ListNode(0);
            }
        }
        ListNode listNode = head;
        while (listNode.next != null){
            if(listNode.next.val==val){
                listNode.next = listNode.next.next;
            }else {
                listNode = listNode.next;
            }
        }
        return head;
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
