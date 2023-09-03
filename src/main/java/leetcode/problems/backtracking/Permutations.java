package leetcode.problems.backtracking;

import java.util.*;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList();
        backtrack(nums, res, new LinkedList());
        return res;
    }

    void backtrack(int[] nums, List<List<Integer>> res, List<Integer> subset) {
        if (subset.size() == nums.length) {
            res.add(new ArrayList<>(subset));
        } else if (subset.size() < nums.length) {
            for (int i = 0; i < nums.length; i++) {
                int can = nums[i];
                if (!subset.contains(can)) {
                    subset.add(can);
                    //System.out.println(subset);
                    backtrack(nums, res, subset);
                    subset.remove(subset.size() - 1);
                }
            }
        }
    }
}
