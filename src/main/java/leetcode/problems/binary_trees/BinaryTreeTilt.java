package leetcode.problems.binary_trees;

import leetcode.problems.top_interview_150.binary_tree_general.TreeNode;

public class BinaryTreeTilt {

    public int findTilt(TreeNode root) {
        int diff = 0;
        if (root != null) {
            int leftV = sum(root.left);
            int rightV =  sum(root.right);

            diff = Math.abs(rightV - leftV);
            System.out.println("diff is: " + diff);
            return diff + findTilt(root.left) + findTilt(root.right);
        }
        return 0;
    }

    private int sum(TreeNode node) {
        if (node != null) {
            return node.val + sum(node.left) +  sum(node.right);
        }
        return 0;
    }

}
