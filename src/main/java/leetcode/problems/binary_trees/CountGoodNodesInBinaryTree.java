package leetcode.problems.binary_trees;

import leetcode.problems.top_interview_150.binary_tree_general.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CountGoodNodesInBinaryTree {

    // recursive approach
    public int goodNodes(TreeNode root) {
        return 1 + goodNodes(root.left, root.val) + goodNodes(root.right, root.val);
    }

    public int goodNodes(TreeNode node, int maxSoFar) {
        if (node != null) {
            int result = 0;
            if (node.val >= maxSoFar) {
                result = 1;
            }
            maxSoFar = Math.max(maxSoFar, node.val);
            return result + goodNodes(node.left, maxSoFar) + goodNodes(node.right, maxSoFar);
        }
        return 0;
    }

    // iterative approach
    public int goodNodesIterative(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        int maxSoFar = Integer.MIN_VALUE;

        if (root != null) {
            q.add(root);
        }

        int counter = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    if (node.left.val >= node.val)
                        counter++;
                    int currentMax = Math.max(node.left.val, node.val);
                    q.add(new TreeNode(currentMax, node.left.left, node.left.right));
                }
                if (node.right != null) {
                    if (node.right.val >= node.val)
                        counter++;
                    int currentMax = Math.max(node.right.val, node.val);
                    q.add(new TreeNode(currentMax, node.right.left, node.right.right));
                }
            }
        }

        return counter;
    }
}
