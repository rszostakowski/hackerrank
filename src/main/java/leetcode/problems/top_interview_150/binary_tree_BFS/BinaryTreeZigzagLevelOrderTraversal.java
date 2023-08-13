package leetcode.problems.top_interview_150.binary_tree_BFS;

import leetcode.problems.top_interview_150.binary_tree_general.TreeNode;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
            if (level.size()!=0) {
                if (res.size() % 2 == 0)
                    Collections.reverse(level);
                res.add(level);
            }
        }
        return res;
    }

    // recursive
    public List<List<Integer>> zigzagLevelOrderRecursive(TreeNode root) {
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
        List<Integer> level = res.get(height);
        if (height % 2 ==0) {
            level.add(root.val);
        } else {
            level.add(0, root.val);
        }
        height +=1;
        levelHelper(res, root.left, height);
        levelHelper(res, root.right, height);
    }
}
