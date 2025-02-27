package linkedlist.fundamentals;

import linkedlist.ListNode;

public class InsertAtKthNode {
    public static void main(String[] args) {
        System.out.println(insertAtKthPosition(ListNode.defaultLinkedList(), 7, 2));
    }

    private static ListNode insertAtKthPosition(ListNode head, int X, int K) {
        if (head == null) return new ListNode(X);
        if(K <= 1)return new ListNode(X,head);

        int count = 1;
        ListNode curr = head;
        while (count < K - 1 && curr.next != null) {
            curr = curr.next;
            count++;
        }

        curr.next = new ListNode(X, curr.next);
        return head;
    }
}
