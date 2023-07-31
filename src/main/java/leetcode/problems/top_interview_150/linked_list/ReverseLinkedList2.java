package leetcode.problems.top_interview_150.linked_list;

public class ReverseLinkedList2 {
    public static void main(String[] args) {
        ListNode node2 = new ListNode(5, null);
        ListNode head = new ListNode(3, node2);

        // Printing the linked list

        ListNode current = reverseBetween(head, 1, 2);
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main2(String[] args) {

        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);

        // Printing the linked list

        ListNode current = reverseBetween(head, 2, 4);
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");

    }
    public static ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode root = head;
        ListNode leftBarMinus1;
        ListNode leftBar;

        // finding left -1
        int counter = 0;
        while(counter < left-1){
            head = head.next;
            counter++;
        }
        leftBarMinus1 = head;

        head = head.next;
        counter++;
        leftBar = head;


        ListNode prev = head;
        head = head.next;
        counter++;
        ListNode next = null;
        while(head != null && counter <= right){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
            counter++;
        }

        // connect leftBar with the rest
        if (next != null) {
            ListNode rightBarPlus1 = next;
            leftBarMinus1.next = prev;
            leftBar.next = rightBarPlus1;
        }
        //
        return root;
    }
}
