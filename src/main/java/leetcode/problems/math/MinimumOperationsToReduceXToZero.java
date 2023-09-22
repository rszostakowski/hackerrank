package leetcode.problems.math;

import java.util.*;

public class MinimumOperationsToReduceXToZero {
    public static void main(String[] args) {
       int[] nums = {1,1,4,2,3};
       int x = 5;

       minOperations(nums, x);
    }

    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        Set<List<Integer>> res = new HashSet();
        Arrays.sort(candidates);
        backtrack(nums, res, x, new LinkedList(), 0, n-1);
    }

    private void backtracking() {

    }

    void backtrack(int[] nums, Set<List<Integer>> res, List<Integer> subset, int target, int  i, int j) {
        int summed = subset.stream().mapToInt(Integer::intValue).sum();

        if (summed == target) {
            System.out.println("summed: " + summed);
            System.out.println("subset: " + subset);
            res.add(subset);
        } else if (summed < target) {
                System.out.println(subset);
                subset.add(nums[i]);
                //System.out.println(subset);
                backtrack(candidates, res, target, subset, i);
                subset.remove(subset.size() - 1);
                System.out.println(subset);

        }
    }
}
