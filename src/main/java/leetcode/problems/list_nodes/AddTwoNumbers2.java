package leetcode.problems.list_nodes;

public class AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sumofNodes = l1.val + l2.val;
        ListNode listOfNodes = new ListNode(sumofNodes % 10);
        ListNode root = listOfNodes;
        int prev = 0;
        if (sumofNodes >= 10) {
            prev = 1;
        }
        l1 = l1.next;
        l2 = l2.next;

        while (l1 != null || l2 != null) {
            int result = prev;
            if (l1 != null) {
                result += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                result += l2.val;
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

    public ListNode AddTwoNumbers(ListNode l1, ListNode l2)
    {
        ListNode result = new ListNode();
        ListNode head = result;
        int sum = 0;
        while (l1 != null || l2 != null || sum > 0) // to keep running if we hava a value in l1, l2 or carry
        {
            // two if statments because l1 and l2 can be of different sizes
            if (l1 != null)
            {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null)
            {
                sum += l2.val;
                l2 = l2.next;
            }
            result.next=new ListNode(sum % 10); //digit
            sum /= 10; //carry
            result = result.next;
        }
        return head.next; //we don't want to return head as it will add a node=0 at the start so -> wrong answer
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
            {
            }
        }
    }
}
