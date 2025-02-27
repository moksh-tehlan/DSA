package linkedlist.logicbuilding;

import linkedlist.ListNode;

public class RemoveNthNodeFromBack {
    public static void main(String[] args) {
        int[] arr = new int[]{1};
        System.out.println(removeNthFromEnd(ListNode.arrayToListNode(arr),1));
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)return null;
        int totalNodes = 0;
        ListNode traverseNode = head;
        while (traverseNode != null) {
            totalNodes++;
            traverseNode = traverseNode.next;
        }

        int nodeBeforeTheNodeToBeRemoved = totalNodes - n;
        if(nodeBeforeTheNodeToBeRemoved == 0)return head.next;
        traverseNode = head;
        while (nodeBeforeTheNodeToBeRemoved-- > 1) {
            traverseNode = traverseNode.next;
        }

        traverseNode.next = traverseNode.next.next;
        return head;
    }
}
