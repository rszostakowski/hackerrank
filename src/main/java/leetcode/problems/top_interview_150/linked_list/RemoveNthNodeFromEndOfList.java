package leetcode.problems.top_interview_150.linked_list;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int numOfEl =0;
        ListNode root = head;
        while (head != null) {
            head = head.next;
            numOfEl++;
        }

        int counter = 1;
        int positon = numOfEl - n;

        head = root;
        while (counter < positon ) {
            head = head.next;
            counter++;
        }

        if (positon == 0) {
            return root.next;
        } else if (n == 1) {
            head.next = null;
        } else{
            ListNode plus2 = head.next.next;
            head.next = plus2;
        }
        return root;
    }

    // Brilliant idea
    public ListNode removeNthFromEndBest(ListNode head, int n) {
        ListNode fast = head, slow = head;
        for (int i = 0; i < n; i++) fast = fast.next;
        if (fast == null) return head.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
