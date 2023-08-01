package leetcode.problems.top_interview_150.graph;

import java.util.Stack;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        Stack<TreeNode> st = new Stack();
        st.push(root);

        while (!st.isEmpty()) {

            TreeNode node = st.pop();

            if (node != null) {
                TreeNode right = node.right;
                TreeNode left = node.left;

                if (right== null && left == null && node.val == targetSum) {
                    return true;
                }
                if (right != null) {
                    right.val = right.val + node.val;
                }
                if (left != null) {
                    left.val = left.val + node.val;
                }
                st.push(right);
                st.push(left);
            }
        }

        return false;
    }

    //recursive approach
    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return hasPathSum(root, 0, targetSum);
    }

    public boolean hasPathSum(TreeNode root, int currentSum, int targetSum) {

        if (root != null) {
            currentSum += root.val;
            if (root.left==null && root.right == null && currentSum == targetSum) {
                return true;
            }

            return hasPathSum(root.left, currentSum, targetSum) || hasPathSum(root.right, currentSum, targetSum);
        }

        return false;
    }
}
