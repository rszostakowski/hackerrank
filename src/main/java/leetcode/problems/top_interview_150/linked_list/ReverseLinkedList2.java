package leetcode.problems.top_interview_150.linked_list;

import static leetcode.problems.list_nodes.ReverseLinkedList.reverseList;

public class ReverseLinkedList2 {
    public static void main4(String[] args) {
        ListNode node3 = new ListNode(6, null);
        ListNode node2 = new ListNode(5, node3);
        ListNode head = new ListNode(3, node2);

        // Printing the linked list

        ListNode current = reverseBetween(head, 1, 2);
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);

        // Printing the linked list

        ListNode current = reverseBetween(head, 2, 4);
        //ListNode current = reverseList(head);
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");

    }

    public static ListNode reverseBetweenMy(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode root = head;

        int counter = 1;
        ListNode before = null;
        while (counter < left) {
            before= head;
            head = head.next;
            counter++;
        }

        ListNode start = head;

        while(counter < right){
            head = head.next;
            counter++;
        }

        ListNode end = head;
        ListNode after = end.next;
        end.next = null;
        ListNode reversedFirst = reverseList(start);

        if(before == null)
            root = reversedFirst;
        else {
            before.next = reversedFirst;
        }

        start.next = after;
        return root;
    }

    // best from the solution section
    // TODO analyse it https://leetcode.com/problems/reverse-linked-list-ii/solutions/30666/simple-java-solution-with-clear-explanation/
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0); // created dummy node
        dummy.next = head;
        ListNode prev = dummy; // intialising prev pointer on dummy node

        for(int i = 0; i < left - 1; i++)
            prev = prev.next; // adjusting the prev pointer on it's actual index

        ListNode curr = prev.next; // curr pointer will be just after prev
        // reversing
        for(int i = 0; i < right - left; i++){
            ListNode forw = curr.next; // forw pointer will be after curr
            curr.next = forw.next;
            forw.next = prev.next;
            prev.next = forw;
        }
        return dummy.next;
    }
}
