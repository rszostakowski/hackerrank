package leetcode.problems.backtracking;

import java.util.*;

public class Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> res = new HashSet();
        Arrays.sort(nums);
        backtrack(nums, res, new ArrayList<>(), 0);
        return new LinkedList<>(res);
    }

    public void backtrack(int[] nums, Set<List<Integer>> res, List<Integer> subset, int startIndex) {
        res.add(new ArrayList<>(subset));

        for (int i = startIndex; i < nums.length; i++) {
            subset.add(nums[i]);
            System.out.println(subset);
            backtrack(nums, res, subset, i+1);
            subset.remove(subset.size() - 1);
        }
    }
}
