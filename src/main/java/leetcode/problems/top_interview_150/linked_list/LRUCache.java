package leetcode.problems.top_interview_150.linked_list;

import java.util.HashMap;

class LRUCache {

    public static void main3(String[] args) {
        //["LRUCache","put","get","put","get","get"]
        //[[1],[2,1],[2],[3,2],[2],[3]]
        LRUCache lRUCache = new LRUCache(1);
        lRUCache.put(2, 1); // cache is {1=1}
        lRUCache.get(2);    // return 1
        lRUCache.put(3, 2); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.get(3);    // return 3
    }

    public static void main2(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1);    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);    // return 4
    }

//    ["LRUCache","get","put","get","put","put","get","get"]
//            [[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.get(2);
        lRUCache.put(2, 6);
        lRUCache.get(1);
        lRUCache.put(1, 5);
        lRUCache.put(1, 2);
        lRUCache.get(1);
        System.out.println(lRUCache.get(2));
    }

    ListNode head = null;
    ListNode tail = null;

    HashMap<Integer, Integer> map;
    int capacity;
    int currentCapacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            moveElementToTail(key);
            return map.get(key);
        }
        return -1;
    }

    private void moveElementToTail(int key) {
        ListNode current = this.head;
        ListNode prev = null;

        if(tail.val == key){
            return;
        }

        while (current != null && current.val != key) {
            prev = current;
            current = current.next;
        }
        if (prev == null ){
            head = head.next;
        }else {
            prev.next = current.next;
        }

        // adding it back to end of the list
        addNewNodeToTail(key);
    }

    public void put(int key, int value) {
        // If the number of keys exceeds the capacity from this operation
        if (map.containsKey(key)){
            moveElementToTail(key);
            map.put(key, value);
            return;
        }

        if (currentCapacity == capacity) {
            // remove first node
            map.remove(head.val);
            head = head.next;
        } else {
            currentCapacity++;
        }

        addNewNodeToTail(key);
        map.put(key, value);
    }

    private void addNewNodeToTail(int key) {
        ListNode newNode = new ListNode(key);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // TODO check the best solution https://leetcode.com/problems/lru-cache/solutions/45911/java-hashtable-double-linked-list-with-a-touch-of-pseudo-nodes/
}
