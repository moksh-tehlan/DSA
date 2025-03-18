package stackques.faqs;

import java.util.HashMap;

class LRUCache {

    Node head;
    Node tail;
    int capacity;
    HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);

        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        Node headNext = this.head.next;
        this.head.next = node;
        node.next = headNext;
        headNext.prev = node;
        node.prev = this.head;
        return node.val;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            // remove last node if capacity is full
            if (map.size() >= capacity) {
                Node lastNode = this.tail.prev;
                map.remove(lastNode.key);
                Node lPrevNode = lastNode.prev;

                lPrevNode.next = this.tail;
                this.tail.prev = lPrevNode;
            }

            Node newNode = new Node(key, value);
            map.put(key, newNode);
            Node headNext = this.head.next;

            head.next = newNode;
            newNode.prev = head;

            newNode.next = headNext;
            headNext.prev = newNode;
        } else {
            Node existingNode = map.get(key);
            existingNode.val = value;

            Node headNext = this.head.next;

            head.next = existingNode;
            existingNode.prev = head;

            existingNode.next = headNext;
            headNext.prev = existingNode;
        }
    }

}

class Node {
    public int key, val;
    public Node next, prev;

    // Constructors
    Node() {
        key = val = -1;
        next = prev = null;
    }

    Node(int k, int value) {
        key = k;
        val = value;
        next = prev = null;
    }
}