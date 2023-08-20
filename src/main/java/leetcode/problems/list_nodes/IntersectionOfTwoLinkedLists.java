package leetcode.problems.list_nodes;

import leetcode.problems.top_interview_150.linked_list.ListNode;

import java.util.List;

public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);

        // Printing the linked list

        ListNode current = copy(head);
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode copiedA = copy(headA);
        ListNode copiedB = copy(headB);
        ListNode reversedA = reverse(copiedA);
        ListNode reversedB = reverse(copiedB);

        while(reversedA!=null && reversedB!=null && !reversedB.equals(reversedA)){
            reversedA = reversedA.next;
            reversedB = reversedB.next;
        }
        return reversedA;
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;

        while(head != null) {
            ListNode next = new ListNode(head.next.val, head.next);
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

    public static ListNode copy(ListNode list){
        if (list == null)
            return null;

        ListNode res = new ListNode(list.val);
        ListNode resTmp = res;
        ListNode listTmp = list;

        while (listTmp.next != null){
            listTmp = listTmp.next;
            resTmp.next = new ListNode(listTmp.val);
            resTmp = resTmp.next;
        }

        return res;
    }

}
