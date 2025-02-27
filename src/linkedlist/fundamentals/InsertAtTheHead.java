package linkedlist.fundamentals;

import linkedlist.ListNode;

public class InsertAtTheHead {
    public static void main(String[] args) {
        System.out.println(insertAtHead(ListNode.defaultLinkedList(),7));
    }

    private static ListNode insertAtHead(ListNode head, int x) {
        return new ListNode(x,head);
    }
}
