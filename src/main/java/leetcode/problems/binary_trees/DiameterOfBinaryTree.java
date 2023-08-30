package leetcode.problems.binary_trees;

import leetcode.problems.top_interview_150.binary_tree_general.TreeNode;

public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        return Math.max(
                diameterOfBinaryTree(root.left),
                Math.max(diameterOfBinaryTree(root.right), maxDepth(root.left) + maxDepth(root.right)));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
