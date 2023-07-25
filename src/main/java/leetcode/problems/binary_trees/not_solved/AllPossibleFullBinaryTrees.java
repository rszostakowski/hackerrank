package leetcode.problems.binary_trees.not_solved;

import java.util.LinkedList;
import java.util.List;

public class AllPossibleFullBinaryTrees {

    public static void main(String[] args) {
        allPossibleFBT(5);
    }

    // https://leetcode.com/problems/all-possible-full-binary-trees/editorial/
    // https://www.youtube.com/watch?v=1vG2fEeyUuU&t=548s&ab_channel=CodeLab
    public static List<TreeNode> allPossibleFBT(int n) {

        List<TreeNode> variants = new LinkedList();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);

        int nMinus3 = n -3;
        addTree(nMinus3, root.left, variants);
        addTree(nMinus3, root.right, variants);

        // TreeNode root = new TreeNode(0);
        // root.left = new TreeNode(1);
        // root.right = new TreeNode(2);
        // root.left.left = new TreeNode(3);
        // root.left.right = new TreeNode(4);

        // bfs zeby wyswietlic
        //printLevelOrder(n, root);
        return variants;
    }

    private static void addTree(int nMinus, TreeNode root, List<TreeNode> variants) {
        if (nMinus ==  0) {
            variants.add(root);
        }

        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        // copy current binary tree
        addTree(nMinus-2, copyTree(root.left), variants);
        addTree(nMinus-2, copyTree(root.right), variants);
    }

    private static TreeNode copyTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode copy = new TreeNode(root.val);
        copy.left = copyTree(root.left);
        copy.right = copyTree(root.right);
        return copy;
    }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
  }
}