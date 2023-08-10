package leetcode.problems.top_interview_150.linked_list;

public class PartitionList {
    public static void main(String[] args) {

        //[1,4,3,2,5,2], x = 3
        ListNode node6 = new ListNode(2);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(2, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(4, node3);
        ListNode head = new ListNode(1, node2);

        // Printing the linked list

        ListNode current = partition(head, 3);
        //ListNode current = reverseList(head);
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main2(String[] args) {
        ListNode node2 = new ListNode(1);
        ListNode head = new ListNode(1, node2);

        // Printing the linked list

        ListNode current = partition(head, 1);
        //ListNode current = reverseList(head);
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    public static ListNode partitionMy(ListNode head, int x) {
        ListNode dummyLeft = new ListNode(0);
        ListNode left = dummyLeft;
        ListNode dummyLeftRight = new ListNode(0);
        ListNode leftRight = dummyLeftRight;
        ListNode dummyRight = new ListNode(0);
        ListNode right = dummyRight;

        ListNode partition = null;
        boolean xWasFound = false;
        while(head != null) {
            int currentVal = head.val;
            if (!xWasFound && currentVal == x) {
                xWasFound = true;
                partition = head;
            } else if(currentVal < x) {
                left.next = head;
                left = left.next;
            } else {
                if (xWasFound) {
                    right.next = head;
                    right = right.next;
                } else {
                    leftRight.next = head;
                    leftRight = leftRight.next;
                }

            }
            head = head.next;
        }

        // end the right list
        right.next = null;
        // connect the left part (element smaller than x) with the right hand (element bigger than x but but before x);
        if (dummyLeftRight.next != null) {
            left.next = dummyLeftRight.next;
            leftRight.next = partition;
        } else {
            left.next = partition;
        }
        if (partition != null) {
            // connect the partitioned part with right
            partition.next = dummyRight.next;
        }

        return dummyLeft.next;
    }

    // best solution from the comments section:
    //https://leetcode.com/problems/partition-list/solutions/2315494/java-c-detailed-explanation/
    public static ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0), dummy2 = new ListNode(0);  //dummy heads of the 1st and 2nd queues
        ListNode curr1 = dummy1, curr2 = dummy2;      //current tails of the two queues;
        while (head!=null){
            if (head.val<x) {
                curr1.next = head;
                curr1 = head;
            }else {
                curr2.next = head;
                curr2 = head;
            }
            head = head.next;
        }
        curr2.next = null;          //important! avoid cycle in linked list. otherwise u will get TLE.
        curr1.next = dummy2.next;
        return dummy1.next;
    }
}
