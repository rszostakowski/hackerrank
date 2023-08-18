package leetcode.problems.binary_trees;

import leetcode.problems.top_interview_150.binary_tree_general.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int n = nums.length;
        return helper(nums, 0, n);
    }

    public TreeNode helper(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = (low + high)/2;
        System.out.println("mid: " + mid);
        if (mid < 0 || mid > nums.length-1) {
            return null;
        }
        TreeNode node = new TreeNode(nums[mid]);

        node.left = helper(nums, low, mid-1);
        node.right = helper(nums, mid+1, high);

        return node;
    }
}
