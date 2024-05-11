package com.kyong.suixianglu.b链表;

/**
 * @author kyong
 * @date 2023/4/7 15:48
 */
//707.设计链表
public class b设计链表 {
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
    class MyLinkedList {
        int size;
        //虚拟头节点
        ListNode head;

        public MyLinkedList() {
            size = 0;
            head = new ListNode(0);
        }

        public int get(int index) {
            if(index > size - 1 || index<0){
                return -1;
            }
            ListNode cur = head;
            for (int i = 0;i <= index; i++){
                cur = cur.next;
            }
            return cur.val;

        }

        public void addAtHead(int val) {
            addAtIndex(0,val);
        }

        public void addAtTail(int val) {
            addAtIndex(size,val);
        }

        public void addAtIndex(int index, int val) {
            if(index > size) {
                return;
            }
            if(index<0){
                index = 0;
            }
            size++;
            ListNode pre = head;
            ListNode node = new ListNode(val);
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }
            node.next = pre.next;
            pre.next = node;

        }

        public void deleteAtIndex(int index) {
            if(index<0 || index>=size){
                return;
            }
            ListNode pre = head;
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }
            pre.next = pre.next.next;
            size--;
        }
    }


}
