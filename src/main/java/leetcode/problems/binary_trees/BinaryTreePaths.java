package leetcode.problems.binary_trees;

import leetcode.problems.top_interview_150.binary_tree_general.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePaths {
    List<String> paths = new LinkedList();

    // recursive
    public List<String> binaryTreePaths(TreeNode root) {
        binaryTreePaths(root, "");
        return paths;
    }

    public void binaryTreePaths(TreeNode root, String path) {
        if (root != null) {
            if (path.length() != 0)
                path += "->";
            path += root.val;
            if (root.right == null && root.left == null) {
                paths.add(path);
            }
            binaryTreePaths(root.left, path);
            binaryTreePaths(root.right, path);
        }
    }

    public List<String> binaryTreePathsIterative(TreeNode root) {

        if (root == null) {
            return paths;
        }

        Stack<TreeNode> st = new Stack();
        Stack<String> pathSt = new Stack();
        st.push(root);

        while(!st.isEmpty()) {

            TreeNode node = st.pop();
            String path = "";
            if (!pathSt.isEmpty())
                path = pathSt.pop();

            if (node != null) {
                if(path.length() != 0) {
                    path +="->";
                }
                path += node.val;
                pathSt.push(path);
                pathSt.push(path);
                if (node.left == null && node.right == null)
                    paths.add(path);
                st.push(node.left);
                st.push(node.right);
            }
        }

        return paths;
    }
}
