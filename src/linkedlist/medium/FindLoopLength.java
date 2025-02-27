package linkedlist.medium;

import linkedlist.ListNode;

public class FindLoopLength {
    public static void main(String[] args) {

    }

    private static int findLengthOfLoop(ListNode head) {
        int count = 0;
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
                count = 1;
                slow = slow.next;
                while(!slow.equals(fast)){
                    slow = slow.next;
                    count++;
                }
                return count;
            }
        }
        return count;
    }
}
