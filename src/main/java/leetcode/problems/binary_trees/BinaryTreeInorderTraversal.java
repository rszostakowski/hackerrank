package leetcode.problems.binary_trees;

import leetcode.problems.top_interview_150.binary_tree_general.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList();
        display(root, res);
        return res;
    }

    public void display(TreeNode node, List<Integer> res) {
        if (node != null) {
            display(node.left, res);
            res.add(node.val);
            display(node.right, res);
        }
    }

    // iterative approach
    public List<Integer> inorderTraversalIter(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode cur = root;

        while (cur != null || !st.empty()) {
            while(cur!=null) {
                st.add(cur);
                cur = cur.left;
            }

            cur = st.pop();
            list.add(cur.val);
            cur = cur.right;
        }


        return list;
    }



}
