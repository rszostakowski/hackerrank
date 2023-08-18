package leetcode.problems.binary_trees;

import leetcode.problems.top_interview_150.binary_tree_general.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree
{
    public int minDepth(TreeNode root) {
        if (root != null) {
            if (root.left != null & root.right == null) {
                return 1 + minDepth(root.left);
            }
            if (root.left == null & root.right != null) {
                return 1 + minDepth(root.right);
            }
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }

        return 0;
    }

    // iterative
    public int minDepthIterative(TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        int counter = 0;

        if(root != null) {
            q.add(root);
        }

        while(!q.isEmpty()) {
            counter++;

            int size = q.size();
            for (int i =0; i<size;i++) {
                TreeNode node = q.poll();
                if (node!=null) {
                    q.add(node.left);
                    q.add(node.right);
                    if (node.left == null && node.right ==null) {
                        return counter;
                    }
                }
            }
        }

        return counter;
    }
}
