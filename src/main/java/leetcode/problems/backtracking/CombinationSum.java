package leetcode.problems.backtracking;

import java.util.*;

public class CombinationSum {
    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        int[] candidates = new int[]{2,3,6,7};
        int target = 7;
        System.out.println(cs.combinationSum(candidates, target));
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> res = new HashSet();
        Arrays.sort(candidates);
        backtrack(candidates, res, target, new LinkedList(), 0);
        return new LinkedList<>(res);
    }

    void backtrack(int[] candidates, Set<List<Integer>> res, int target, List<Integer> subset, int startIndex) {
        int summed = subset.stream().mapToInt(Integer::intValue).sum();

        if (summed == target) {
            System.out.println("summed: " + summed);
            System.out.println("subset: " + subset);
            res.add(subset);
        } else if (summed < target) {
            for (int i = startIndex; i < candidates.length; i++) {
                subset.add(candidates[i]);
                //System.out.println(subset);
                backtrack(candidates, res, target, subset, i);
                subset.remove(subset.size() - 1);
            }
        }
    }
}
