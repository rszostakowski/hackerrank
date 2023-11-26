package leetcode.problems.binary_trees;

import leetcode.problems.top_interview_150.binary_tree_general.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class ConstructStringFromBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode leftleft = new TreeNode(4);
        left.right = leftleft;
        TreeNode right = new TreeNode(3);
        root.left=left;
        root.right=right;
        System.out.println(tree2str(root));
        //System.out.println("1(2(4))(3)");
        System.out.println("1(2()(4))(3)");

    }

    public static String tree2str(TreeNode root) {
        List<String> sb = new LinkedList<>();
        display(root, sb);
        return concatenateAndReverse(sb);
    }

    public static void display(TreeNode node, List<String> sb) {
// && (node.left != null || node.right != null)
            if (node != null ) {
                if (node.right != null)
                    sb.add(")");
                display(node.right, sb);
                if (node.right != null)
                    sb.add("(");
                if (node.left != null || node.right != null)
                    sb.add(")");
                display(node.left, sb);
                if (node.left != null || node.right != null)
                    sb.add("(");
            }

            if (node != null) {
                sb.add("" + node.val);
            }
    }

    private static String concatenateAndReverse(List<String> strings) {
        StringBuilder sb = new StringBuilder();

        for (int i = strings.size()-1; i >= 0; i--) {
            sb.append(strings.get(i));
        }

        return sb.toString();
    }

    // best
    public String tree2str_best(TreeNode t) {
        if (t == null) return "";

        String result = t.val + "";

        String left = tree2str_best(t.left);
        String right = tree2str_best(t.right);

        if (left == "" && right == "") return result;
        if (left == "") return result + "()" + "(" + right + ")";
        if (right == "") return result + "(" + left + ")";
        return result + "(" + left + ")" + "(" + right + ")";
    }
}
