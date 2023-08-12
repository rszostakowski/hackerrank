package leetcode.problems.top_interview_150.binary_tree_BFS;

import leetcode.problems.top_interview_150.binary_tree_general.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList();
        if (root != null)
            q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new LinkedList();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node != null) {
                    q.add(node.left);
                    q.add(node.right);
                    level.add(node.val);
                }
            }
            if (level.size()!=0)
                res.add(level);
        }
        return res;
    }


    // recursive
    public List<List<Integer>> levelOrderRecursive(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        levelHelper(res, root, 0);
        return res;
    }

    public void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null){
            return;
        }
        if (height >= res.size()) {
            res.add(new LinkedList());
        }

        res.get(height).add(root.val);
        height +=1;
        levelHelper(res, root.left, height);
        levelHelper(res, root.right, height);
    }
}
