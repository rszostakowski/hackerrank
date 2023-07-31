package leetcode.problems.top_interview_150.linked_list;

public class LinkedListCycle {

    // my initial solution
    public boolean hasCycle(ListNode head) {
        for (int i= 0; i< 1000000; i++) {
            if (head == null) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    // Floyd’s Cycle-Finding Algorithm - this is coooool! https://leetcode.com/problems/linked-list-cycle/description/
    //Floyd’s Cycle-Finding Algorithm // fast slow approach // 2 pointers // "tortoise and the hare algorithm"
    public boolean hasCycle2(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while(true) {
            if (fast == null || fast.next == null) {
                return false;
            }

            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }
    }
}
