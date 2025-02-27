package linkedlist.fundamentals;

import linkedlist.ListNode;

public class DeleteNodeWithElement {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        System.out.println(deleteNodeWithValueX(ListNode.arrayToListNode(arr), 6));
    }

    private static ListNode deleteNodeWithValueX(ListNode head, int x) {
        ListNode curr = head;
        if (curr == null) return null;
        ListNode prev = null;
        while (curr != null) {
            if (curr.val == x) {
                if (prev == null) return head.next;
                if (prev.next != null && prev.next.next != null) {
                    prev.next = prev.next.next;
                } else {
                    prev.next = null;
                }
            }
            prev = curr;
            curr = curr.next;
        }
        return head;
    }
}
