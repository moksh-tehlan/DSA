package linkedlist.medium;

import linkedlist.ListNode;

public class AddOne {
    public static void main(String[] args) {
        System.out.println(addOne(ListNode.arrayToListNode(new int[]{9,8})));
    }

    private static ListNode addOne(ListNode head) {
        ListNode reverseHead = reverseList(head);
        int carry = 1;
        ListNode curr = reverseHead;

        while (curr != null) {
            int sum = carry + curr.val;
            int reminder = sum % 10;
            carry = sum / 10;


            curr.val = reminder;
            if (curr.next == null && carry != 0) {
                curr.next = new ListNode();
            }
            curr = curr.next;

        }

        return reverseList(reverseHead);
    }

    private static ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
