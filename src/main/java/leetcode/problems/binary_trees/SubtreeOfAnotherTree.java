package leetcode.problems.binary_trees;

import leetcode.problems.top_interview_150.binary_tree_general.TreeNode;

public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (isTheSameTree(root, subRoot))
            return true;

        if (root != null)
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

        return false;
    }

    public boolean isTheSameTree(TreeNode p, TreeNode l) {
        if (p == null && l !=null)
            return false;
        if (p != null && l ==null)
            return false;
        if (p == null && l ==null)
            return true;

        if (p.val != l.val)
            return false;

        return isTheSameTree(p.left, l.left) && isTheSameTree(p.right, l.right);
    }
}
