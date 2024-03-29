package leetcode.problems.top_interview_150.binary_tree_general;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeMaximumPathSum {
    // working but I am not proud of this solution
    List<Integer> maxes = new LinkedList();
    public int maxPathSum(TreeNode root) {
        int max1 = maxPathSum(root, "");
        int max2 = maxes.stream().max(Integer::compareTo).orElse(Integer.MIN_VALUE);
        return Math.max(max1, max2);
    }

    public int maxPathSum(TreeNode root, String str) {
        if (root.left == null && root.right ==null)
            return root.val;

        int sum = root.val;
        if (root.left != null && root.right != null) {
            int left = maxPathSum(root.left, "");
            int right = maxPathSum(root.right, "");

            int max = Math.max(sum,  Math.max(sum + left, sum + right));
            maxes.add(sum+left+right);
            maxes.add(right);
            maxes.add(left);
            return max;
        }
        if (root.left == null) {
            int right = maxPathSum(root.right, "");
            int max = Math.max(sum, sum + right);
            maxes.add(right);
            return max;
        }

        int left = maxPathSum(root.left, "");
        int max = Math.max(sum, sum + left);
        maxes.add(left);
        return max;
    }

    // best solution from the internet
    //https://neetcode.io/practice
    public int maxPathSumBest(TreeNode root) {
        int[] res = { Integer.MIN_VALUE };
        maxPathSum(root, res);
        return res[0];
    }

    public int maxPathSum(TreeNode root, int[] res) {
        if (root == null) return 0;

        int left = Math.max(0, maxPathSum(root.left, res));
        int right = Math.max(0, maxPathSum(root.right, res));
        res[0] = Math.max(res[0], root.val + left + right);

        return root.val + Math.max(left, right);
    }

}
