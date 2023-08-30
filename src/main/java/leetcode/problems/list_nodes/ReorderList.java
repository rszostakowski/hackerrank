package leetcode.problems.list_nodes;

import leetcode.problems.top_interview_150.linked_list.ListNode;

public class ReorderList {
    public static void main(String[] args) {
        // [1,2,3,4,5]
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);

       reorderList(head);
        while (head!= null) {
            System.out.println(head.val + " ");
            head = head.next;
        }
    }
    public static void reorderList(ListNode head) {
        // find middle element
        ListNode fast = head;
        ListNode slow = head;

        while(fast.next != null && fast.next.next !=null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        System.out.println("middle: " + slow.val);
        ListNode reversed = reverseList2(slow.next);
        slow.next = null;

        // combine two lists takin one element from initial list and second elemenet from reversed
        int idx = 0;
        while(head != null && reversed != null) {
            if (idx % 2 == 0) {
                ListNode next = head.next;
                head.next = reversed;
                reversed = reversed.next;
                head = head.next;
                head.next = next;
            } else {
                head = head.next;
            }
            idx++;
        }
    }

    public static ListNode reverseList2(ListNode head) {
        /* iterative solution */
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
