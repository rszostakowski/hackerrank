package leetcode.problems.list_nodes;

import leetcode.problems.top_interview_150.linked_list.ListNode;

public class RemoveDuplicatesFromSortedList {

    // recursive
    public ListNode deleteDuplicates(ListNode head) {
        if (head != null && head.next != null) {
            if (head.val == head.next.val) {
                return deleteDuplicates(head.next);
            } else {
                head.next = deleteDuplicates(head.next);
                return head;
            }
        }

        return head;
    }

    // iterative
    public ListNode deleteDuplicatesIte(ListNode head) {
        ListNode root = head;
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return root;
    }
}
