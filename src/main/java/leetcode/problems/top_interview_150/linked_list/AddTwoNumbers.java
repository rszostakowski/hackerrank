package leetcode.problems.top_interview_150.linked_list;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sumofNodes = l1.val+l2.val;
        ListNode listOfNodes = new ListNode(sumofNodes % 10);
        ListNode root = listOfNodes;
        int prev = 0;
        if (sumofNodes >= 10) {
            prev = 1;
        }
        l1 = l1.next;
        l2 = l2.next;

        while (l1 != null || l2 !=null) {
            int result = prev;
            if (l1 != null) {
                result+=l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                result+=l2.val;
                l2 = l2.next;
            }

            if (result >= 10) {
                prev = 1;
            } else {
                prev = 0;
            }
            listOfNodes.next = new ListNode(result % 10);
            listOfNodes = listOfNodes.next;
        }

        if (prev != 0) {
            listOfNodes.next = new ListNode(prev);
        }

        return root;
    }

    // here are the solutions for all technical aspects of linkedlists
}
