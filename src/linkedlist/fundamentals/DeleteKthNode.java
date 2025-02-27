package linkedlist.fundamentals;

import linkedlist.ListNode;

public class DeleteKthNode {
    public static void main(String[] args) {
        System.out.println(deleteKthNode(ListNode.defaultLinkedList(),5));
        System.out.println(deleteKthNode(ListNode.defaultLinkedList(0),0));
        System.out.println(deleteKthNode(ListNode.defaultLinkedList(1),1));
        System.out.println(deleteKthNode(ListNode.defaultLinkedList(2),2));
        System.out.println(deleteKthNode(ListNode.defaultLinkedList(3),3));
    }

    private static ListNode deleteKthNode(ListNode head, int k) {
        if(head == null)return  null;
        if(k == 1)return head.next;
        int count = 1;
        ListNode curr = head;
        while(count < k-1 && curr.next != null){
            curr = curr.next;
            count++;
        }

        if(curr.next != null && curr.next.next != null){
            curr.next = curr.next.next;
        }else{
            curr.next = null;
        }
        return head;
    }
}
