package leetcode.problems.top_interview_150.binary_search_tree;

import leetcode.problems.top_interview_150.binary_tree_general.TreeNode;

public class ValidateBinarySearchTree
{
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left1 = new TreeNode(4);
        TreeNode right1 = new TreeNode(6);
        TreeNode left2 = new TreeNode(3);
        TreeNode right2 = new TreeNode(7);
        right1.left = left2;
        right1.right = right2;
        root.left = left1;
        root.right = right1;

        System.out.println(isValidBST(root));
    }

    public static void main2(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(1);
        root.left = left1;

        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {
        return isValidBSTRec(root).isValid;
    }

    static class Result {
        public boolean isValid;
        int min;
        int max;

        public Result(boolean isValid, int min, int max) {
            this.isValid = isValid;
            this.min = min;
            this.max = max;
        }
    }
    public static Result isValidBSTRec(TreeNode root) {
        if (root == null) {
            return new Result(true, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        if (root.left != null || root.right != null) {
            if (root.left == null) {
                Result right = isValidBSTRec(root.right);
                return new Result(
                        root.right.val > root.val && right.isValid && right.min > root.val,
                        right.min,
                        right.max);
            }

            if (root.right == null) {
                Result leftTree = isValidBSTRec(root.left);
                return new Result(
                        root.left.val < root.val && leftTree.isValid && leftTree.max < root.val,
                        leftTree.min,
                        leftTree.max);
            }

            if (root.left.val < root.val && root.right.val > root.val) {
                Result left = isValidBSTRec(root.left);
                Result right = isValidBSTRec(root.right);
                return new Result(
                        left.isValid && right.isValid && right.min > root.val && left.max < root.val,
                        Math.min(left.min, right.min),
                        Math.max(left.max, right.max));
            }
            return new Result(false, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        return  new Result(true, root.val, root.val);
    }
}
