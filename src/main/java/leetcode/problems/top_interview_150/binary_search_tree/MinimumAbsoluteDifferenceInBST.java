package leetcode.problems.top_interview_150.binary_search_tree;

import leetcode.problems.top_interview_150.binary_tree_general.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class MinimumAbsoluteDifferenceInBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        //[4,2,6,1,3]
        System.out.println(getMinimumDifference2(root));
    }


    public int getMinimumDifference(TreeNode root) {
        List<Integer> result = new LinkedList();
        printInorder(root, result);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i< result.size() -1; i++) {
            int diff = result.get(i+1) - result.get(i);
            min = Math.min(diff, min);
        }
        return min;
    }

    void printInorder(TreeNode node, List<Integer> result)
    {
        if (node == null)
            return;

        printInorder(node.left, result);
        result.add(node.val);
        printInorder(node.right, result);
    }

    static int min = Integer.MAX_VALUE;
    static Integer prev = null;


    // hard to understand this solution
    public static int getMinimumDifference2(TreeNode root) {
        if (root == null) return min;

        getMinimumDifference2(root.left);

        if (prev != null) {
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;

        getMinimumDifference2(root.right);

        return min;
    }

    /*
    class Solution(object):
    def getMinimumDifference(self, root):
    def fn(node, lo, hi):
            if not node: return hi - lo
            left = fn(node.left, lo, node.val)
    right = fn(node.right, node.val, hi)
            return min(left, right)
        return fn(root, float('-inf'), float('inf'))

     */
}
