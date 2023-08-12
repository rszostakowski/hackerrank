package leetcode.problems.top_interview_150.binary_tree_general;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        Stack<TreeNode> q = new Stack();

        List<TreeNode> flattened = new LinkedList();
        if (root != null) {
            q.push(root);
            TreeNode lastRight = root;
            while(!q.isEmpty()) {
                int size = q.size();

                for (int i =0; i< size; i++) {
                    TreeNode node = q.pop();

                    if (node!= null) {
                        q.push(node.right);
                        q.push(node.left);

                        // add it to the right
                        node.left = null;
                        if (!node.equals(root)) {
                            lastRight.right = node;
                            lastRight = lastRight.right;
                        }
                    }
                }
            }
        }
    }
}
