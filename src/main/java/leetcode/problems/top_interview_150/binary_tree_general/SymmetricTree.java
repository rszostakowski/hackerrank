package leetcode.problems.top_interview_150.binary_tree_general;

import java.util.Stack;

public class SymmetricTree {

    // first solution - not optimal
    public boolean isSymmetric(TreeNode root) {
        if (root != null) {

            if (root.left == null && root.right == null) return true;
            if (root.left == null || root.right == null) return false;

            TreeNode invRight = invertTree(root.right);
            return isSameTree(root.left, invRight);
        }
        return false;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode invRight = invertTree(root.right);
        TreeNode invLeft = invertTree(root.left);
        root.left = invRight;
        root.right = invLeft;
        return root;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;

        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    // iterative approach
    public boolean isSymmetric2(TreeNode root) {

        Stack<TreeNode> stL = new Stack();
        stL.push(root.left);

        Stack<TreeNode> stR = new Stack();
        stR.push(root.right);

        while(!stL.isEmpty() && !stR.isEmpty()) {
            TreeNode left = stL.pop();
            TreeNode right = stR.pop();
            if (left == null && right == null) continue;
            if (left == null || right == null) return false;

            if (left.val != right.val) {
                return false;
            }
            stL.push(left.right);
            stL.push(left.left);

            stR.push(right.left);
            stR.push(right.right);
        }

        if (stL.isEmpty() || stR.isEmpty()) {
            return true;
        }
        return false;
    }

    //recursive
    public boolean isSymmetric3(TreeNode root) {
        return root==null || isSymmetric(root.left, root.right);
    }

    // recursive
    private boolean isSymmetric(TreeNode left, TreeNode right){
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) {
            return false;
        }

        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
