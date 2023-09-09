package leetcode.problems.backtracking;

import java.util.*;

public class CombinationSum3 {
    public static void main(String[] args) {
        CombinationSum3 cs3 = new CombinationSum3();
        cs3.combinationSum3(3, 7);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        Set<Set<Integer>> res = new HashSet<>();
        int[] nums = new int[] {1,2,3,4,5,6,7,8,9};
        backtrack(nums, res, k, n, new HashSet<>(), 0);
        return convert(res);
    }

    void backtrack(int[] nums, Set<Set<Integer>> res, int k, int target, Set<Integer> subset, int startingPoint) {
        int sum = subset.stream().mapToInt(e->e).sum();
        if (sum == target && subset.size() == k) {
            res.add(new HashSet<>(subset));
        } else if  (sum < target && subset.size()<k) {
            for (int i = startingPoint; i < nums.length; i++) {
                int val = nums[i];
                if (sum + val <= target && subset.size()+1<=k) {
                    Set<Integer> newPartial = new HashSet<Integer>(subset);
                    newPartial.add(val);
                    backtrack(nums, res, k, target, newPartial, i+1);
                    newPartial.remove(newPartial.size()-1);
                }
            }
        }
    }

    private List<List<Integer>> convert(Set<Set<Integer>> res) {
        List<List<Integer>> converted = new LinkedList<>();
        for (Set<Integer> partialSet: res) {
            converted.add(new LinkedList<>(partialSet));
        }
        return converted;
    }
}
