package leetcode.problems.top_interview_150.binary_tree_general;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        TreeNode right3 = new TreeNode(6);
        TreeNode left2 = new TreeNode(3);
        TreeNode right2 = new TreeNode(4);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(5);
        right1.right= right3;
        left1.left= left2;
        left1.right= right2;
        root.left = left1;
        root.right = right1;

        flattenRec(root);
        while (root!= null) {
            System.out.println(root.val);
            root= root.right;
        }
    }
    public static void flatten(TreeNode root) {
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


    // extraordinary solution: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/solutions/36977/my-short-post-order-traversal-java-solution-for-share/
    public static void flattenRec(TreeNode root) {
        if (root == null) return;

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;

        flattenRec(left);
        flattenRec(right);

        root.right = left;
        TreeNode cur = root;
        while (cur.right != null) cur = cur.right;
        cur.right = right;
    }

    TreeNode prev;
    public void flattenBest(TreeNode root) {
        if (root == null)
            return;
        flattenBest(root.right);
        flattenBest(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

}
