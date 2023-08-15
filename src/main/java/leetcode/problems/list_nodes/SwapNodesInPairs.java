package leetcode.problems.list_nodes;

import leetcode.problems.top_interview_150.linked_list.ListNode;

public class SwapNodesInPairs {
    public static void main2(String[] args) {
        ListNode root = new ListNode(1);
        ListNode plus1 = new ListNode(2);
        ListNode plus2 = new ListNode(3);

        root.next = plus1;
        plus1.next = plus2;

        ListNode newRoot = swapPairs(root);
        while(newRoot != null) {
            System.out.println(newRoot.val);
            newRoot = newRoot.next;
        }

    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode plus1 = new ListNode(2);
        ListNode plus2 = new ListNode(3);
        ListNode plus3 = new ListNode(4);

        root.next = plus1;
        plus1.next = plus2;
        plus2.next = plus3;

        ListNode newRoot = swapPairs(root);
        while(newRoot != null) {
            System.out.println(newRoot.val);
            newRoot = newRoot.next;
        }

    }
    public static ListNode swapPairs(ListNode head) {
        ListNode root = head;
        boolean firstIteration = true;
        ListNode prevSwap = null;
        while(head!= null && head.next != null) {
            ListNode plus2 = head.next.next;
            ListNode plus1 = head.next;

            plus1.next = head;
            head.next = null;

            if (firstIteration) {
                root = plus1;
                firstIteration = false;
            } else {
                prevSwap.next= plus1;
            }
            prevSwap = head;
            prevSwap.next = plus2;
            head=plus2;
        }

        return root;
    }

    //recursive approach
    public ListNode swapPairs(ListNode head) {
        if ((head == null)||(head.next == null))
            return head;
        ListNode plus2 = swapPairs(head.next.next);

        //swap
        ListNode plus1 = head.next;
        plus1.next = head;
        head.next = plus2;

        return plus1;
    }

}
