package leetcode.problems.binary_trees;

import leetcode.problems.top_interview_150.binary_tree_general.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class SerializeAndDeserializeBinaryTree {

    public static void main(String[] args) {
        TreeNode root = deserialize("1,2,3,null,null,4,5,");
    }
    public String serialize(TreeNode root) {
        int idx = 0;
        String res = "";
        List<int[]> resArr = new LinkedList();
        Queue<TreeNode> q = new LinkedList();
        int maxDepth = maxDepth(root);
        if (root != null) {
            q.add(root);
        }

        int n = 1;
        int curLvl = 1;
        while(!q.isEmpty() && curLvl <= maxDepth) {
            int size = q.size();
            int[] level = new int[fibo(n)];
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();


                if (node!= null) {
                    q.add(node.left);
                    q.add(node.right);
                    level[i] = node.val;
                    res += node.val;
                } else {
                    q.add(null);
                    q.add(null);
                    level[i] = -1001;
                    res += "null";
                }
                res += ",";
            }
            n++;
            curLvl++;
            resArr.add(level);
            // System.out.println(Arrays.toString(level));
            //res += Arrays.toString(level);
        }

        System.out.println("res: " + res);
        return res;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data.length() >= 1) {
            List<Integer> ints = Arrays.stream(data.substring(0, data.length() - 1).split(","))
                    .map(s -> {
                        if (s == null || s.equalsIgnoreCase("null")) {
                            return null;
                        }
                        return Integer.parseInt(s);
                    })
                    .collect(Collectors.toList());

            ints.forEach(System.out::println);

            return createTree(1, ints);

        }
        return null;
    }

    private static TreeNode createTree(int idx, List<Integer> ints) {
        int n = ints.size();
        int leftIdx = 2 *idx;
        int rightIdx = leftIdx + 1;
        TreeNode left = null;
        TreeNode right = null;

        Integer val = ints.get(idx - 1);
        if (val == null) {
            return null;
        }
        if (leftIdx -1 < n) {
            left = createTree(leftIdx, ints);
        }
        if (rightIdx -1 < n) {
            right = createTree(rightIdx, ints);
        }

        return new TreeNode(val, left, right);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));
    }

    public int fibo(int n) {
        if (n == 1 || n ==2 ) {
            return n;
        }
        return 2*fibo(n-1);
    }
}
