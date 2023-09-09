package leetcode.problems.list_nodes;

import leetcode.problems.top_interview_150.linked_list.ListNode;

public class PalindromeLinkedList {

    // reversing a list but it can be done using recursion too
    public boolean isPalindrome(ListNode head) {
        ListNode current = head;
        int count = 0;

        while (current != null) {
            count++;
            current = current.next;
        }

        int mid = count/2;

        current = head;

        int idx = 0;
        while(idx < mid) {
            idx++;
            current = current.next;
        }

        //System.out.println("first element of second part: " + current.val);

        ListNode prev = null;
        while(current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        //System.out.println("reversed list: " + prev.val);
        ListNode first = head;
        ListNode second = prev;
        while (first != null && second != null) {
            if (first.val != second.val)
                return false;
            //System.out.println("first: " + first.val + " second: " +  second.val);
            first = first.next;
            second = second.next;
        }
        return true;
    }
}
