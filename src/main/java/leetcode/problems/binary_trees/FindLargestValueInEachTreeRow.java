package leetcode.problems.binary_trees;

import leetcode.problems.top_interview_150.binary_tree_general.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new LinkedList();

        Queue<TreeNode> st = new LinkedList();
        if (root != null) {
            st.add(root);
        }

        while(st.size()!=0) {
            int size = st.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = st.poll();
                max = Math.max(max, node.val);
                if (node.left!= null) {
                    st.add(node.left);
                }
                if (node.right!= null) {
                    st.add(node.right);
                }
            }
            result.add(max);
        }

        return result;
    }

    // the most interesting solution
    public List<Integer> largestValues_best(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res, 0);
        return res;
    }
    private void helper(TreeNode root, List<Integer> res, int d){
        if(root == null){
            return;
        }
        //expand list size
        if(d == res.size()){
            res.add(root.val);
        }
        else{
            //or set value
            res.set(d, Math.max(res.get(d), root.val));
        }
        helper(root.left, res, d+1);
        helper(root.right, res, d+1);
    }
}
