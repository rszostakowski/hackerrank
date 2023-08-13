package leetcode.problems.top_interview_150.binary_search_tree;

import leetcode.problems.top_interview_150.binary_tree_general.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KthSmallestElementInABST {
    public static void main(String[] args) {
            TreeNode root = new TreeNode(5);

            TreeNode left3 = new TreeNode(1);
            TreeNode left2 = new TreeNode(2);
            TreeNode right2 = new TreeNode(4);
            TreeNode left1 = new TreeNode(3);
            TreeNode right1 = new TreeNode(6);
            left2.left= left3;
            left1.left= left2;
            left1.right= right2;
            root.left = left1;
            root.right = right1;

            System.out.println(kthSmallestBinary(root, 3));
    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList();
        display(root, res);
        return res.get(k-1);
    }

    public void display(TreeNode root, List<Integer> res) {
        if (root != null) {
            display(root.left, res);
            res.add(root.val);
            display(root.right, res);
        }
    }

    // amazing solutions from the comments section
    static int count = 0;
    static int result = Integer.MAX_VALUE;
    public static int kthSmallestRec(TreeNode root, int k) {
        find(root, k);
        return result;
    }

    public static void find(TreeNode root, int k) {
        if (root != null) {
            find(root.left, k);
            count++;
            if (count == k)
                result = root.val;
            find(root.right, k);
        }
    }

    // the same thing can be achieved using an interative  way
    public int kthSmallestIterative(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        int count = 0;

        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);  // Just like recursion
                p = p.left;

            } else {
                TreeNode node = stack.pop();
                if(++count == k) return node.val;
                p = node.right;
            }
        }

        return Integer.MIN_VALUE;
    }

    // binary!!!
    public static int kthSmallestBinary(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (k <= count) {
            return kthSmallestBinary(root.left, k);
        } else if (k > count + 1) {
            return kthSmallestBinary(root.right, k-1-count); // 1 is counted as current node
        }

        return root.val;
    }

    public static int countNodes(TreeNode n) {
        if (n == null) return 0;

        return 1 + countNodes(n.left) + countNodes(n.right);
    }
}
