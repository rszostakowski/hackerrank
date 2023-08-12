package leetcode.problems.top_interview_150.binary_tree_general;

import java.util.LinkedList;
import java.util.List;

public class LowestCommonAncestorOfABinaryTree {

    public static void main(String[] args) {

       // [3,5,1,6,2,0,8,null,null,7,4]
        TreeNode root = new TreeNode(3);
        TreeNode left4 = new TreeNode(0);
        TreeNode right4 = new TreeNode(8);
        TreeNode left3 = new TreeNode(7);
        TreeNode right3 = new TreeNode(4);
        TreeNode left2 = new TreeNode(6);
        TreeNode right2 = new TreeNode(2);
        TreeNode left1 = new TreeNode(5);
        TreeNode right1 = new TreeNode(1);
        right1.left= left4;
        right1.right= right4;
        right2.left= left3;
        right2.right= right3;
        left1.left= left2;
        left1.right= right2;
        root.left = left1;
        root.right = right1;

        lowestCommonAncestor(root, left2, right2);
    }
    public static TreeNode lowestCommonAncestorMy(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }

        if (hasChild(p, q)) {
            return p;
        }

        if (hasChild(q, p)) {
            return q;
        }

        List<TreeNode> p1 = getParents(root, p, new LinkedList());
        List<TreeNode> p2 = getParents(root, q, new LinkedList());

        int n = p1.size();
        if (p2.size() < n) {
            n = p2.size();
        }

        for (int i = n-1; i>= 0; i--) {
            TreeNode p1Ch = p1.get(i);
            TreeNode p2Ch = p2.get(i);
            if ( p1Ch.val == p2Ch.val)
                return p1Ch;
        }
        return root;
    }

    public static List<TreeNode> getParents(TreeNode parent, TreeNode child, List<TreeNode> path) {
        if (parent == null) {
            return null;
        }

        path.add(parent);
        if (parent.val == child.val){
            return path;
        }

        List<TreeNode> leftPath = getParents(parent.left, child,  new LinkedList<>(path));
        List<TreeNode> rightPath = getParents(parent.right, child,  new LinkedList<>(path));

        if (leftPath != null)
            return leftPath;


        if (rightPath != null)
            return rightPath;

        return null;
    }

    public static boolean hasChild(TreeNode parent, TreeNode potentialChild) {
        if (parent == null) {
            return false;
        }

        if (parent.val == potentialChild.val) {
            return true;
        }

        return hasChild(parent.left, potentialChild) || hasChild(parent.right, potentialChild);
    }

    // best solution from the comments section
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null && right == null) return null;
        if(left != null && right != null) return root;
        return left == null ? right : left;
    }
}
