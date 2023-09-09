package leetcode.problems.backtracking;

import java.util.*;

public class CombinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        Set<List<Integer>> res = new HashSet();
        Arrays.sort(nums);
        backtrack(nums, res, target, new LinkedList());
        return res.size();
    }

    void backtrack(int[] nums, Set<List<Integer>> res, int target, List<Integer> subset) {
        subset.stream().forEach(e -> System.out.print(" " +  e));
        //System.out.println();

        int sum = subset.stream().mapToInt(e->e).sum();
        System.out.println("sum: " + sum);

        if (sum == target) {
            res.add(subset);
        } else if  (sum < target) {
            for (int i = 0; i < nums.length; i++) {
                int val = nums[i];
                if (sum + val <= target) {
                    subset.add(val);
                    //backtrack(nums, res, target, new ArrayList(subset));
                    backtrack(nums, res, target, subset);
                    subset.remove(subset.size()-1);
                }

                //
            }
        }
    }
}
