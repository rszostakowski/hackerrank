package leetcode.problems.top_interview_150.binary_tree_BFS;

import leetcode.problems.top_interview_150.binary_tree_general.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new LinkedList();
        Queue<TreeNode> q = new LinkedList<TreeNode>();

        if (root != null) {
            q.add(root);
        }

        while(!q.isEmpty()) {
            TreeNode right = null;
            int size = q.size(); // this is very important we need to get the all nodes on current graph level
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node != null) {
                    System.out.println(node.val);
                    right = node;
                    q.add(node.left);
                    q.add(node.right);
                }
            }
            if (right != null) {
                res.add(right.val);
            }
        }

        return res;
    }


    // recursive, beatiful approach
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> res = new LinkedList();
        rightSideView(root, res, 1);
        return res;
    }

    public void rightSideView(TreeNode root, List<Integer> res, int depth) {
        if (root != null) {

            if (depth > res.size()) {
                res.add(root.val);
            }

            depth = depth + 1;
            rightSideView(root.right, res, depth);
            rightSideView(root.left, res, depth);
        }
    }
}
