package leetcode.problems.binary_trees;

import leetcode.problems.top_interview_150.binary_tree_general.TreeNode;

import java.util.Stack;

public class MergeTwoBinaryTrees {
    //https://leetcode.com/problems/merge-two-binary-trees/
    public static void main(String[] args) {
        MergeTwoBinaryTrees mergeTwoBinaryTrees = new MergeTwoBinaryTrees();
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(4);
        TreeNode rightright = new TreeNode(5);
        right.right = rightright;
        root2.left = left;
        root2.right = right;
        mergeTwoBinaryTrees.mergeTrees(root1, root2);
    }
    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        return mergeIt(root1, root2);
    }

    private TreeNode mergeIt(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        } else if (root1 == null) {
            System.out.println("1");
            return root2;
        } else if (root2 == null) {
            System.out.println("2");
            return root1;
        } else {
            TreeNode node = new TreeNode(root1.val + root2.val);
            node.left = mergeIt(root1.left, root2.left);
            node.right = mergeIt(root1.right, root2.right);
            return node;
        }
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 == null || t2 == null) {
            return (t1 != null) ? t1 : t2;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(t1);
        stack2.push(t2);

        while (!stack1.isEmpty()) {
            TreeNode c1 = stack1.pop();
            TreeNode c2 = stack2.pop();

            c1.val += c2.val;

            if (c1.left == null && c2.left != null) {
                c1.left = c2.left;
            } else if (c1.left != null && c2.left != null) {
                stack1.push(c1.left);
                stack2.push(c2.left);
            }

            if (c1.right == null && c2.right != null) {
                c1.right = c2.right;
            } else if (c1.right != null && c2.right != null) {
                stack1.push(c1.right);
                stack2.push(c2.right);
            }
        }

        return t1;
    }
}
