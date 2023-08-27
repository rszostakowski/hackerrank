package leetcode.problems.list_nodes;

import leetcode.problems.top_interview_150.linked_list.ListNode;

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {

        // check if first is val
        boolean firstFound = false;
        ListNode root = null;
        ListNode prev = null;
        while (head != null) {
            if (head.val != val && !firstFound) {
                root = head;
                firstFound = true;
                prev = head;
            } else if (head.val == val && firstFound) {
                prev.next = head.next;
            } else {
                prev = head;
            }
            head = head.next;

        }

        return root;
    }

    public ListNode removeElementsRecursive(ListNode head, int val) {
        return removeNextElement(head, val);
    }

    public ListNode removeNextElement(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode next = removeNextElement(head.next, val);
        if (head.val == val) {
            return next;
        }
        head.next = next;
        return head;
    }

    // better solution using dummy node
    // https://leetcode.com/problems/remove-linked-list-elements/solutions/1572932/java-three-simple-clean-solutions-w-explanation-iterative-recursive-beats-100/
    public ListNode removeElementsBest(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;

        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
                // Here cannot move cur to cur.next as we need to validate the next node.
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}
