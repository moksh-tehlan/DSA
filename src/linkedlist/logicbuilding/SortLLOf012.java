package linkedlist.logicbuilding;

import linkedlist.ListNode;

public class SortLLOf012 {
    public static void main(String[] args) {
        System.out.println(sortList(ListNode.arrayToListNode(new int[]{2})));

    }

    private static ListNode sortList(ListNode head) {
        ListNode zeroStartNode = new ListNode();
        ListNode oneStartNode = new ListNode();
        ListNode twoStartNode = new ListNode();

        ListNode traverseNode = head;

        ListNode zeroTraverse = zeroStartNode;
        ListNode oneTraverse = oneStartNode;
        ListNode twoTraverse = twoStartNode;

        while (traverseNode != null) {
            if (traverseNode.val == 0) {
                zeroTraverse.next = traverseNode;
                zeroTraverse = zeroTraverse.next;
            }
            if (traverseNode.val == 1) {
                oneTraverse.next = traverseNode;
                oneTraverse = oneTraverse.next;
            }

            if (traverseNode.val == 2) {
                twoTraverse.next = traverseNode;
                twoTraverse = twoTraverse.next;
            }

            traverseNode = traverseNode.next;
        }
        zeroTraverse.next = oneStartNode.next == null ? twoStartNode.next : oneStartNode.next;
        oneTraverse.next = twoStartNode.next;
        twoTraverse.next = null;
        return zeroStartNode.next;
    }
}
