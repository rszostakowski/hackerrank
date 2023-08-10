package leetcode.problems.top_interview_150.linked_list;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {

        ListNode root = head;
        int numOfEl =0;
        ListNode lastNode = null;
        while (head != null) {
            lastNode = head;
            head = head.next;
            numOfEl ++;
        }

        ListNode fast = root;

        if (numOfEl == 0) {
            return root;
        }
        k = k % numOfEl;

        if (k == 0) {
            return root;
        }

        ListNode prev = null;
        for (int i =0; i < numOfEl-k; i++) {
            prev = fast;
            fast = fast.next;

        }

        prev.next = null;
        ListNode newRoot = fast;
        lastNode.next = root;

        return newRoot;
    }
}
