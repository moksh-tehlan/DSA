package linkedlist.medium;

import linkedlist.ListNode;

public class CheckPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(ListNode.arrayToListNode(new int[]{3, 7,9,5, 7, 3})));
    }

    private static boolean isPalindrome(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow
                    .next;
            fast = fast.next.next;
        }

        ListNode checkNode = reverseLl(fast == null ? slow : slow.next);
        while(checkNode != null){
            if(checkNode.val != head.val){
                return false;
            }
            checkNode = checkNode.next;
            head = head.next;
        }
        return true;
    }

    private static ListNode reverseLl(ListNode head) {
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
