package leetcode.problems.top_interview_150.binary_tree_BFS;

import leetcode.problems.top_interview_150.graph.TreeNode;

import java.util.*;

public class AverageOfLevelsInBinaryTree {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int player = scanner.nextInt();
        //System.out.println("Player: " + player);
        int position = scanner.nextInt();
        //System.out.println("Position: " + position);

        scanner.nextLine();
        String line = scanner.nextLine();

        int[] bids1 = new int[0];
        int[] bids2;
        if (line.length() != 0) {
            String[] split1 = line.split(" ");


            bids1 = Arrays.stream(split1)
                    .mapToInt(Integer::parseInt)
                    .toArray();

            System.out.println(Arrays.toString(bids1));
        }

        String line2 = scanner.nextLine();
        if (line2.length() != 0) {
            String[] split2 = line2.split(" ");


            bids2 = Arrays.stream(split2)
                    .mapToInt(Integer::parseInt)
                    .toArray();

            System.out.println(Arrays.toString(bids2));
        }

        int left = 100 - Arrays.stream(bids1).sum();
        System.out.println("Player1 has: " + left);
        scanner.close();


        System.out.println(20);
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new LinkedList();
        Queue<TreeNode> q = new LinkedList();

        q.add(root);

        while (!q.isEmpty()) {

            int size = q.size();

            long summed = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                if (node != null) {
                    summed += node.val;
                    if (node.right != null) {
                        q.add(node.right);
                    }
                    if (node.left != null) {
                        q.add(node.left);
                    }
                }
            }

            double avg = (double) summed / size;
            res.add(avg);
        }

        return res;
    }
}
