package leetcode.problems.top_interview_150.binary_tree_general;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTreeIterator {
    Queue<TreeNode> q;
    public BinarySearchTreeIterator(TreeNode root) {
        q = new LinkedList();
        inOrder(root);
    }

    public void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.left);
            q.add(node);
            inOrder(node.right);
        }
    }

    public int next() {
        return q.poll().val;
    }

    public boolean hasNext() {
        return !q.isEmpty();
    }
}


//best solution from the comments section
class BSTIterator {
    private Stack<TreeNode> stack = new Stack<TreeNode>();

    public BSTIterator(TreeNode root) {
        pushAll(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode tmpNode = stack.pop();
        pushAll(tmpNode.right);
        return tmpNode.val;
    }

    private void pushAll(TreeNode node) {
        for (; node != null; stack.push(node), node = node.left);
    }
}