package leetcode.problems.binary_trees;

import leetcode.problems.top_interview_150.binary_tree_general.TreeNode;

public class LowestCommonAncestorOfBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == p.val
                || root.val == q.val
                || (root.val > p.val && root.val < q.val)
                || (root.val > q.val && root.val < p.val))
            return root;

        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        else
            return lowestCommonAncestor(root.left, p, q);
    }

    // best solution from the internet
    //https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/solutions/1347857/c-java-python-iterate-in-bst-picture-explain-time-o-h-space-o-1/
    public TreeNode lowestCommonAncestorBest(TreeNode root, TreeNode p, TreeNode q) {
        int small = Math.min(p.val, q.val);
        int large = Math.max(p.val, q.val);
        while (root != null) {
            if (root.val > large) // p, q belong to the left subtree
                root = root.left;
            else if (root.val < small) // p, q belong to the right subtree
                root = root.right;
            else // Now, small <= root.val <= large -> This root is the LCA between p and q
                return root;
        }
        return null;
    }
}
