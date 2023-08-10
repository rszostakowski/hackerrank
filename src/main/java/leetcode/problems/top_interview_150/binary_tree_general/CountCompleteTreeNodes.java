package leetcode.problems.top_interview_150.binary_tree_general;

import java.util.Stack;

public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        Stack<TreeNode> st = new Stack();

        if (root != null) {
            st.push(root);
        }
        int counter = 0;
        while (!st.isEmpty()) {
            TreeNode node = st.pop();

            if (node != null) {
                counter++;
                st.push(node.left);
                st.push(node.right);
            }
        }

        return counter;
    }

    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes2(root.left) + countNodes2(root.right);
    }
}
