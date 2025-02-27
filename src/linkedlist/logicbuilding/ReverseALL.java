package linkedlist.logicbuilding;

import linkedlist.ListNode;

public class ReverseALL {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2};
        System.out.println(reverseList(ListNode.arrayToListNode(arr)));
    }

    private static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode curr = head;
        ListNode prev = null;
        ListNode oldNext;

        while (curr != null) {
            oldNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = oldNext;
        }

        return prev;
    }
}
