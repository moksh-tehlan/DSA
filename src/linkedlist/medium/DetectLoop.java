package linkedlist.medium;

import linkedlist.ListNode;

public class DetectLoop {
    public static void main(String[] args) {
    }

    private static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.equals(fast)) {
                return true;
            }
        }
        return false;
    }
}
