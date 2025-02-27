package linkedlist.fundamentals;

import linkedlist.ListNode;

public class DeletionOfTail {
    public static void main(String[] args) {
        ListNode head = ListNode.defaultLinkedList();
        System.out.println(deleteTail(head));
    }
    private static ListNode deleteTail(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }

        ListNode curr = head;
        ListNode prev = null;
        while(curr.next != null){
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
        return head;
    }
}
