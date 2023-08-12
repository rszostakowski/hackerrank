package leetcode.problems.top_interview_150.binary_tree_general;

import java.util.LinkedList;
import java.util.List;

public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        List<Integer> sums = new LinkedList();
        display(root, "", sums);
        return sums.stream().mapToInt(e->e).sum();
    }

    public void display(TreeNode node, String sum, List<Integer> sums) {
        if (node != null) {
            if(node.left == null && node.right == null) {
                sum += node.val;
                sums.add(Integer.parseInt(sum));
            } else {
                display(node.left, sum + node.val, sums);
                display(node.right, sum + node.val, sums);
            }
        }
    }


    //beatiful solution from the comments section
    public int sumNumbersOther(TreeNode root) {
        return sum(root, 0);
    }

    public int sum(TreeNode n, int s){
        if (n == null) return 0;
        if (n.right == null && n.left == null) return s*10 + n.val;
        return sum(n.left, s*10 + n.val) + sum(n.right, s*10 + n.val);
    }
}
