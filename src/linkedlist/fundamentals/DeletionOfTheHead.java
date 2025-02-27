package linkedlist.fundamentals;

import linkedlist.ListNode;

public class DeletionOfTheHead {
    public static void main(String[] args) {
        ListNode head = ListNode.defaultLinkedList();
        System.out.println(deleteHead(head));
    }

    private static ListNode deleteHead(ListNode head) {
        if(head == null)return null;
        head = head.next;
        return head;
    }
}
