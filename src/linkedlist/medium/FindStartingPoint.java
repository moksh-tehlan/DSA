package linkedlist.medium;

import linkedlist.ListNode;

public class FindStartingPoint {
    public static void main(String[] args) {

    }

    private static ListNode findStartingPoint(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.equals(fast)) {
                slow = head;
                while(!slow.equals(fast)){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
