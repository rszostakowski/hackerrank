package leetcode.problems.top_interview_150.linked_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeKSortedLists {
    public static void main(String[] args) {
        //[[1,4,5],[1,3,4],[2,6]]
        ListNode node13 = new ListNode(5, null);
        ListNode node12 = new ListNode(4, node13);
        ListNode head1 = new ListNode(1, node12);

        ListNode node23 = new ListNode(4, null);
        ListNode node22 = new ListNode(3, node23);
        ListNode head2 = new ListNode(1, node22);

        ListNode node32 = new ListNode(6, null);
        ListNode node3 = new ListNode(2, node32);

        ListNode[] lists =  {head1, head2, node3};
        ListNode res = mergeKLists(lists);
        while (res!= null) {
            System.out.println(res.val + " ");
            res = res.next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        return mergeKLists(dummy, lists);
    }

    public static ListNode mergeKLists(ListNode merged, ListNode[] lists) {
        int n = lists.length;

        int smallest = Integer.MAX_VALUE;
        int idx = -1;
        ListNode smallestNode = null;

        for (int i = 0; i < n; i++) {
            ListNode current = lists[i];
            if (current != null) {
                int val = current.val;
                //System.out.println("val: " + val);
                if (smallest > val) {
                    smallest = val;
                    smallestNode = current;
                    idx = i;
                }
            }
        }
        if (smallestNode != null) {
            merged.next = smallestNode;
            merged = merged.next;
            lists[idx] = smallestNode.next;
            merged.next = mergeKLists(merged, lists);
            return merged;
        }

        return null;
    }
}
