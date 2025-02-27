package linkedlist.medium;

import linkedlist.ListNode;

public class DeleteMiddle {
    public static void main(String[] args) {
        System.out.println(deleteMiddle(ListNode.arrayToListNode(new int[]{1, 2, 3, 4, 5,6})));
    }

    private static ListNode deleteMiddle(ListNode head) {
        if (head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;
        return head;
    }
}
