package leetcode.problems.binary_trees;

import leetcode.problems.top_interview_150.binary_tree_general.TreeNode;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root != null) {
            int depthLeft = getDepth(root.left);
            int depthRight = getDepth(root.right);

            if (Math.abs(depthLeft - depthRight) <=1) {
                return isBalanced(root.left) && isBalanced(root.right);
            }
            return false;
        }
        return true;
    }
    public int getDepth(TreeNode root) {
        if (root != null) {
            return 1 + Math.max(getDepth(root.left), getDepth(root.right));
        }
        return 1;
    }
}
