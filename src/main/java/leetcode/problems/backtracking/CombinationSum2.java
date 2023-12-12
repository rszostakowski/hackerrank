package leetcode.problems.backtracking;
import java.util.*;

public class CombinationSum2 {

    //https://leetcode.com/problems/combination-sum-ii/
    public static void main(String[] args) {
        CombinationSum2 cs = new CombinationSum2();
        int[] candidates = new int[] {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        cs.combinationSum2(candidates, 27);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> res = new HashSet();
        Arrays.sort(candidates);
        backtrack(candidates, res, target, new LinkedList(), 0);
        return new ArrayList<>(res);
    }

    void backtrack(int[] candidates, Set<List<Integer>> res, int target, List<Integer> subset,  int startIndex) {
        int summed = subset.stream().mapToInt(Integer::intValue).sum();
        if (summed == target) {
            res.add(new ArrayList(subset));
        } else if (subset.size() <= candidates.length && summed < target) {
            for (int i = startIndex; i < candidates.length; i++) {
                if(i > startIndex && candidates[i] == candidates[i-1]) continue; // skip duplicates
                subset.add(candidates[i]);
                System.out.println(subset);
                backtrack(candidates, res, target, subset, i+1);
                subset.remove(subset.size() -1);
            }

        }
    }
}
