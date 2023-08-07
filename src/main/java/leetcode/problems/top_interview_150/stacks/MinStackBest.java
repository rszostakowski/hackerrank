package leetcode.problems.top_interview_150.stacks;

public class MinStackBest {
    // that is extreme solution!
    public static void main(String[] args) {
        MinStackBest minStack = new MinStackBest();
        minStack.push(1);
        minStack.push(2);
        minStack.push(3);
        minStack.top();      // Output: 2147483647
        minStack.pop();
        minStack.getMin();   // Output: 2147483646
        minStack.pop();
        minStack.getMin();   // Output: 2147483646
        minStack.pop();
        minStack.push(4);
        minStack.top();      // Output: 2147483647
        minStack.getMin();   // Output: 2147483647
        minStack.push(-2147483648);
        minStack.top();      // Output: -2147483648
        minStack.getMin();   // Output: -2147483648
        minStack.pop();
        minStack.getMin();   // Output: 2147483647
    }

        private Node head;

        public void push(int x) {
            if (head == null)
                head = new Node(x, x, null);
            else
                head = new Node(x, Math.min(x, head.min), head);
        }

        public void pop() {
            head = head.next;
        }

        public int top() {
            return head.val;
        }

        public int getMin() {
            return head.min;
        }

        private class Node {
            int val;
            int min;
            Node next;

            private Node(int val, int min, Node next) {
                this.val = val;
                this.min = min;
                this.next = next;
            }
        }

}
