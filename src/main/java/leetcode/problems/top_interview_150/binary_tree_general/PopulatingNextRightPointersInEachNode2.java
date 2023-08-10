package leetcode.problems.top_interview_150.binary_tree_general;


import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode2 {

    // TODO analyse other solutions https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/?envType=study-plan-v2&envId=top-interview-150

    public Node connect(Node root) {
        Queue<Node> q = new LinkedList<Node>();
        if (root != null) {
            q.add(root);
        }

        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                Node next = q.peek();

                if (node != null) {
                    node.next = null;
                    if (next != null && i != size -1) {
                        node.next = next;
                    }
                    if (node.left != null)
                        q.add(node.left);
                    if (node.right != null)
                        q.add(node.right);
                }
            }
        }


        return root;
    }
}
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};