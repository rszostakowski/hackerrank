package leetcode.problems.backtracking;

import java.util.*;

public class CombinationSum4 {


    public static void main(String[] args) {
        CombinationSum4 cs4 = new CombinationSum4();
        int target = 4;
        int[] nums = new int[]{1,2,3};
        cs4.combinationSum4(nums, target);
    }

    static int[] cache = new int[200];
    public int combinationSum4(int[] nums, int target) {
        Set<Map<Integer, Integer>> res = new HashSet();
        Arrays.sort(nums);
        backtrack(nums, res, target, new HashMap());

        int counter = 0;
        for (Map<Integer, Integer> entry: res) {
            int combination = combination(entry);
            counter += combination;
        }
        return counter;
    }

    private int combination(Map<Integer, Integer> entry) {
        int numOfElements = 0;
        int denominator = 1;
        for (int count: entry.values()) {
            denominator *= factorial(count);
            numOfElements += count;
        }

        return factorial(numOfElements)/ denominator;
    }

    private static int factorial(int k) {
        if (k == 1)
            return 1;

        if (cache[k] != 0) {
            return cache[k];
        }

        int res = k * factorial(k-1);
        cache[k] = res;
        return res;
    }

    void backtrack(int[] nums, Set<Map<Integer, Integer>> res, int target, Map<Integer, Integer> partial) {
        if (0 == target) {
            res.add(new HashMap(partial));
            partial.forEach((key, value) -> System.out.print(" key: " + key + " val: " + value));
            System.out.println();
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (val <= target) {
                Map<Integer, Integer> newPartial = new HashMap<>(partial);
                newPartial.put(val, newPartial.getOrDefault(val, 0) + 1);
                backtrack(nums, res, target - val, newPartial);
            }
        }
    }

    public int combinationSum4_old(int[] nums, int target) {
        Set<List<Integer>> res = new HashSet();
        Arrays.sort(nums);
        backtrack_old(nums, res, target, new LinkedList());
        return res.size();
    }

    void backtrack_old(int[] nums, Set<List<Integer>> res, int target, List<Integer> subset) {
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
                    backtrack_old(nums, res, target, subset);
                    subset.remove(subset.size()-1);
                }

                //
            }
        }
    }
}
