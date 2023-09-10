package leetcode.problems.backtracking;

import java.util.*;

public class CombinationSum3 {
    public static void main(String[] args) {
        CombinationSum3 cs3 = new CombinationSum3();
        cs3.combinationSum3(3, 7);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new LinkedList<>();
        int[] nums = new int[] {1,2,3,4,5,6,7,8,9};
        backtrack(nums, res, k, n, new LinkedList<>(), 0);
        return res;
    }

    void backtrack(int[] nums, List<List<Integer>> res, int k, int target, List<Integer> subset, int startingPoint) {
        if (0 == target && subset.size() == k) {
            res.add(new LinkedList<>(subset));
            return; // TODO this is the most important part of the solution
        }

        for (int i = startingPoint; i < nums.length; i++) {
            int val = nums[i];
            subset.add(val);
            backtrack(nums, res, k, target-val, subset, i+1);
            subset.remove(subset.size()-1);
        }
    }

    // best solution from the comments section
    public List<List<Integer>> combinationSum3Best(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        combination(ans, new ArrayList<Integer>(), k, 1, n);
        return ans;
    }

    private void combination(List<List<Integer>> ans, List<Integer> comb, int k,  int start, int n) {
        if (comb.size() == k && n == 0) {
            List<Integer> li = new ArrayList<Integer>(comb);
            ans.add(li);
            return;
        }
        for (int i = start; i <= 9; i++) {
            comb.add(i);
            combination(ans, comb, k, i+1, n-i);
            comb.remove(comb.size() - 1);
        }
    }
}
