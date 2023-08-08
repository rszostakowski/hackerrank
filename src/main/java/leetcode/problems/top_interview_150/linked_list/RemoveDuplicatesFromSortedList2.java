package leetcode.problems.top_interview_150.linked_list;

public class RemoveDuplicatesFromSortedList2 {
    public static void main3(String[] args) {
        //[1,2,3,3,4,4,5]
        ListNode node7 = new ListNode(5);
        ListNode node6 = new ListNode(4, node7);
        ListNode node5 = new ListNode(4, node6);
        ListNode node4 = new ListNode(3, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);

        // Printing the linked list

        ListNode current = deleteDuplicates(head);
        //ListNode current = reverseList(head);
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        //[1,1,1,2,3]
        ListNode node5 = new ListNode(3);
        ListNode node4 = new ListNode(2, node5);
        ListNode node3 = new ListNode(1, node4);
        ListNode node2 = new ListNode(1, node3);
        ListNode head = new ListNode(1, node2);

        // Printing the linked list

        ListNode current = deleteDuplicates(head);
        //ListNode current = reverseList(head);
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    public static void main2(String[] args) {
        ListNode node3 = new ListNode(2);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);

        // Printing the linked list

        ListNode current = deleteDuplicates(head);
        //ListNode current = reverseList(head);
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }


    // my solution
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode start = new ListNode(-101);
        ListNode root = start;

        ListNode prev = head;
        head = head.next;
        int previouslyDeleted = -101;
        while (head !=null) {
            if (head.val == prev.val) {
                previouslyDeleted = head.val;
            } else if (prev.val == previouslyDeleted){
                previouslyDeleted = -101;
            } else {
                start.next = prev;
                start = start.next;
                start.next = null;
            }
            prev = head;
            head = head.next;
        }

        // add last node
        if (previouslyDeleted != prev.val) {
            start.next = prev;
        }
        return root.next;
    }
}
