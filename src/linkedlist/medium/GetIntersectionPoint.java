package linkedlist.medium;

import linkedlist.ListNode;


public class GetIntersectionPoint {
    public static void main(String[] args) {
        ListNode headA = ListNode.arrayToListNode(new int[]{1, 2, 3, 4, 5});
        ListNode headB = ListNode.arrayToListNode(new int[]{7, 8, 4, 5});
        System.out.println(getIntersectionNode(headA, headB));
    }

    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = 0;
        int sizeB = 0;

        ListNode currA = headA;
        ListNode currB = headB;

        while (currA != null || currB != null) {
            if (currA != null) {
                sizeA++;
                currA = currA.next;
            }
            if (currB != null) {
                sizeB++;
                currB = currB.next;
            }
        }

        if (sizeB > sizeA) {
            return getIntersectionNode(headB, headA);
        }

        while (sizeA > sizeB) {
            headA = headA.next;
            sizeA--;
        }

        while (sizeA > 1) {
            headA = headA.next;
            headB = headB.next;
            sizeA--;
        }


        if (headA.val == headB.val) {
            return headA;
        }

        return null;
    }
}
