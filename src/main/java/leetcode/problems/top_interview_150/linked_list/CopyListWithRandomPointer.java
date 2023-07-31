package leetcode.problems.top_interview_150.linked_list;


import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

    public Node copyRandomList(Node head) {
        if (head != null) {
            Map<Node, Node> cache = new HashMap();
            Node newHead = copyNode(head, cache);
            Node copiedHead = newHead;

            head = head.next;

            while(head != null) {
                Node n = copyNode(head, cache);
                newHead.next = n;
                newHead = newHead.next;
                head = head.next;
            }

            newHead = copiedHead;
            while (newHead != null) {
                newHead.random = cache.get(newHead.random);
                newHead = newHead.next;
            }

            return copiedHead;
        }
        return head;
    }

    public Node copyNode(Node old,  Map<Node, Node> cache){
        Node newN = new Node(old.val);
        newN.random = old.random;
        cache.put(old, newN);
        return newN;
    }

    // the best solution from the internet - which DOES not use HASHMAP
    // https://leetcode.com/problems/copy-list-with-random-pointer/solutions/43491/a-solution-with-constant-space-complexity-o-1-and-linear-time-complexity-o-n/
    public Node copyRandomList2(Node head) {
        Node iter = head, next;

        // First round: make copy of each node,
        // and link them together side-by-side in a single list.
        while (iter != null) {
            next = iter.next;

            Node copy = new Node(iter.val);
            iter.next = copy;
            copy.next = next;

            iter = next;
        }

        // Second round: assign random pointers for the copy nodes.
        iter = head;
        while (iter != null) {
            if (iter.random != null) {
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }

        // Third round: restore the original list, and extract the copy list.
        iter = head;
        Node pseudoHead = new Node(0);
        Node copy, copyIter = pseudoHead;

        while (iter != null) {
            next = iter.next.next;

            // extract the copy
            copy = iter.next;
            copyIter.next = copy;
            copyIter = copy;

            // restore the original list
            iter.next = next;

            iter = next;
        }

        return pseudoHead.next;
    }
}


