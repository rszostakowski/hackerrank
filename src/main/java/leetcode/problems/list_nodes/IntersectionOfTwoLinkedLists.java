package leetcode.problems.list_nodes;

import leetcode.problems.top_interview_150.linked_list.ListNode;

import java.util.List;

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int countA = 0;
        int countB = 0;

        ListNode currentA = headA;
        ListNode currentB = headB;

        while (currentA != null) {
            countA++;
            currentA = currentA.next;
        }

        while (currentB != null) {
            countB++;
            currentB = currentB.next;
        }

        currentA = headA;
        currentB = headB;

        if (countA > countB) {
            int diff = countA - countB;
            int idx = 0;
            while (idx < diff) {
                currentA = currentA.next;
                idx++;
            }
        } else {
            int diff = countB - countA;
            int idx = 0;
            while (idx < diff) {
                currentB = currentB.next;
                idx++;
            }
        }

        System.out.println("Should be on the same level A: " + currentA.val + " B " +  currentB.val);

        for (int i = 0; i < 3*100000; i++) {
            if (currentA == currentB) {
                return currentA;
            }
            currentA = currentA.next;
            currentB = currentB.next;
        }

        return null;
    }


    // solution without knowing the length of the lists
    //https://leetcode.com/problems/intersection-of-two-linked-lists/solutions/49785/java-solution-without-knowing-the-difference-in-len/
    // 4 different solutions

    public ListNode getIntersectionNodeBest(ListNode headA, ListNode headB) {
        //boundary check
        if(headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while( a != b){
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }

        return a;
    }
}
