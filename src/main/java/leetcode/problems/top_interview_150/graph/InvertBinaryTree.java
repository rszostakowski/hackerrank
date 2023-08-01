package leetcode.problems.top_interview_150.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InvertBinaryTree {

    // recursive
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

    public TreeNode invertTree2(TreeNode root) {
        // BFS
        Queue<TreeNode> q = new LinkedList();
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node != null) {
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
                System.out.println(node.val);
                q.add(node.left);
                q.add(node.right);
            }
        }
        return root;
    }

    public TreeNode invertTree3(TreeNode root) {
        // DFS
        Stack<TreeNode> s = new Stack();
        s.push(root);

        while(!s.isEmpty()) {
            TreeNode node = s.pop();
            if (node != null) {
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
                System.out.println(node.val);
                s.push(node.right); // this will make sure that we will start traversing the tree from left
                s.push(node.left);
            }
        }
        return root;
    }
}
