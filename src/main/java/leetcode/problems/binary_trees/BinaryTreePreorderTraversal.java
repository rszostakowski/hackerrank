package leetcode.problems.binary_trees;

import leetcode.problems.top_interview_150.binary_tree_general.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> results = new LinkedList();
        display(root, results);
        return results;
    }

    public void display(TreeNode node, List<Integer> results) {
        if (node != null) {
            results.add(node.val);
            display(node.left, results);
            display(node.right, results);
        }
    }

    // iterative approach
    public List<Integer> preorderTraversalIterative(TreeNode root) {
        Stack<TreeNode> st = new Stack();
        List<Integer> res = new LinkedList();

        if (root!= null) {
            st.push(root);
        }

        while(!st.isEmpty()) {
            TreeNode node = st.pop();
            if (node !=null) {
                res.add(node.val);
                st.push(node.right);
                st.push(node.left);
            }
        }

        return res;
    }
}
