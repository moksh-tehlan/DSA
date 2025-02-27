package linkedlist;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
        this.val = 0;
        this.next = null;
    }

    public ListNode(int data) {
        this.val = data;
        this.next = null;
    }

    public ListNode(int data, ListNode next) {
        this.val = data;
        this.next = next;
    }

    public static ListNode defaultLinkedList() {
        ListNode head = new ListNode(1, null);
        ListNode curr = head;
        for (int i = 2; i <= 50; i++) {
            curr.next = new ListNode(i, null);
            curr = curr.next;
        }
        return head;
    }

    public static ListNode defaultLinkedList(int items) {
        if(items == 0)return null;
        ListNode head = new ListNode(1, null);
        ListNode curr = head;
        for (int i = 2; i <= items; i++) {
            curr.next = new ListNode(i, null);
            curr = curr.next;
        }
        return head;
    }

    public static ListNode arrayToListNode(int[] arr){
        ListNode head = new ListNode(arr[0],null);
        ListNode curr = head;
        for(int i = 1; i < arr.length; i++){
            curr.next = new ListNode(arr[i],null);
            curr = curr.next;
        }
        return head;
    }

    @Override
    public String toString() {
        ListNode curr = this;
        StringBuilder sb = new StringBuilder();
        while(curr != null){
            sb.append(curr.val).append(" ");
            curr = curr.next;
        }
        return sb.toString();
    }
}

