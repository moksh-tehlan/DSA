package linkedlist.logicbuilding;

import linkedlist.ListNode;

public class OddEventList {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6};
        ListNode head = ListNode.arrayToListNode(arr);
        System.out.println(oddEvenList(head));
    }

    private static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode even = head;
        ListNode odd = head.next;
        ListNode firstOdd = odd;

        while (odd != null && odd.next != null){
            even.next = even.next.next;
            even = even.next;

            odd.next = odd.next.next;
            odd = odd.next;
        }

        even.next = firstOdd;
        return head;
    }
}
