package linkedlist.fundamentals;

import linkedlist.ListNode;

public class InsertionAtTheTail {
    public static void main(String[] args) {
        System.out.println(insertAtTail(ListNode.defaultLinkedList(),10));
    }

    private static ListNode insertAtTail(ListNode head, int X) {
        if(head == null)return new ListNode(X,null);

        ListNode curr = head;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = new ListNode(X);
        return head;
    }
}
