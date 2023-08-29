package leetcode.problems.top_interview_150.linked_list;

public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        // [1,2,3,4,5]
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);

        ListNode res = reverseKGroup(head, 3);
        while (res!= null) {
            System.out.println(res.val + " ");
            res = res.next;
        }
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;

        // check if the reversing iteration is possible
        int counter = 0;
        while (counter < k && head != null) {
            head = head.next;
            counter++;
        }

        // pointing again to the starting node
        head = start;
        if (counter == k && head != null) {

            // reversing the sub squeuence
            ListNode prev = null;
            for(int i = 0; i < k; i++){
                ListNode next = head.next;
                head.next = prev;
                prev = head;
                head = next;
            }

            // taking the first node from reversed chain and trying to add the rest
            start.next = reverseKGroup(head, k);
            return prev;
        }
        return head;
    }
}
