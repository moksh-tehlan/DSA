package linkedlist.fundamentals;

import linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;

public class TraversalInLinkedList {
    public static void main(String[] args) {
        ListNode head = ListNode.defaultLinkedList();
        List<Integer> list = LLTraversal(head);
        for(Integer i : list){
            System.out.print(i+" ");
        }
    }

    private static List<Integer> LLTraversal(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }
        return list;
    }
}
