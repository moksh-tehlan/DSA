package linkedlist.logicbuilding;

import linkedlist.ListNode;

public class AddTwoNumbers {
    public static void main(String[] args) {
        int[] arr1 = new int[]{9, 9, 9, 9, 9, 9, 9, 1};
        int[] arr2 = new int[]{9, 9, 9, 9, 9, 9, 9, 1};
        ListNode l1 = ListNode.arrayToListNode(arr1);
        ListNode l2 = ListNode.arrayToListNode(arr2);
        System.out.println(addTwoNumbers(l1, l2));
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        int carry = 0;
        ListNode head = new ListNode();
        ListNode curr = head;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }
        return head.next;
    }
}
