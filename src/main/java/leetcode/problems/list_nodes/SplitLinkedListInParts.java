package leetcode.problems.list_nodes;

import leetcode.problems.top_interview_150.linked_list.ListNode;

public class SplitLinkedListInParts {

    // my solution, maybe not the best, but works!
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] nodes =  new ListNode[k];
        int count = 0;

        ListNode current = head;
        while(current != null) {
            count++;
            current = current.next;
        }

        int numOfLists = count/ k;
        int extra = count % k;

        nodes[0]=head;
        int idx = 1;
        int subSeqCounter = 1;
        while(head != null && idx < k) {
            ListNode next = head.next;
            if (extra > 0) {
                if (subSeqCounter == numOfLists+1) {
                    extra--;
                    nodes[idx] = next;
                    idx++;
                    subSeqCounter = 0;
                    head.next = null;
                }
            } else {
                if (subSeqCounter == numOfLists) {
                    nodes[idx] = next;
                    idx++;
                    subSeqCounter = 0;
                    head.next = null;
                }
            }

            subSeqCounter++;
            head = next;
        }

        return nodes;
    }
}
