package leetcode.problems.binary_trees;

import leetcode.problems.top_interview_150.binary_tree_general.TreeNode;

import java.util.Stack;

public class SumOfLeftLeaves {

        public int sumOfLeftLeaves(TreeNode root) {
            Stack<TreeNode> st = new Stack();
            st.push(root);

            int sum = 0;
            while(!st.isEmpty()) {
                TreeNode node = st.pop();

                if (node != null) {
                    if (node.left != null && node.left.left == null && node.left.right == null) {
                        sum += node.left.val;
                    }
                    st.push(node.left);
                    st.push(node.right);
                }
            }

            return sum;
        }
}
