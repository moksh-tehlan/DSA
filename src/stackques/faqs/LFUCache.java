package stackques.faqs;

import java.util.HashMap;

class LFUCache {

    Node head;
    Node tail;

    HashMap<Integer, Node> map;
    int capacity;
    int usageCounter;
    Node mostFrequentNode;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        return 0;
    }

    public void put(int key, int value) {
    }
}