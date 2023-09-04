package leetcode.problems.backtracking;

import java.util.*;


// all backtracing problems are desribed here: https://leetcode.com/problems/subsets/solutions/27281/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning/

public class Subsets {

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int[] nums = {1,2,3};
        subsets.subsets(nums);
    }
    public List<List<Integer>> subsets(int[] nums) {
        Set<List<Integer>> res = new HashSet();
        backtrack(nums, res, new ArrayList<>(), 0);
        return  new LinkedList<>(res);
    }

    public void backtrack(int[] nums, Set<List<Integer>> res, List<Integer> subset, int startIndex) {
        res.add(new ArrayList<>(subset));

        for (int i = startIndex; i < nums.length; i++) {
            subset.add(nums[i]);
            System.out.println(subset);
            backtrack(nums, res, subset, i + 1);
            subset.remove(subset.size() - 1); // this is the important setp in the backtracking problem
        }
    }

    // FS approach - very smart
    public List<List<Integer>> subsetsBFS(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int n : nums){
            int size = result.size();
            for(int i=0; i<size; i++){
                List<Integer> subset = new ArrayList<>(result.get(i));
                subset.add(n);
                result.add(subset);
            }
        }
        return result;
    }
}
