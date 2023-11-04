package leetcode.problems.contests.biweekly_contest_116;

import java.util.*;

public class Ex3 {
    public static void main(String[] args) {
        Ex3 ex1 = new Ex3();
        System.out.println("3 == " + ex1.lengthOfLongestSubsequence(List.of(1,2,3,4,5), 9));
        // 1, 3, 6,
        System.out.println("4 == " + ex1.lengthOfLongestSubsequence(List.of(4,1,3,2,1,5), 7));
        System.out.println("-1 == " + ex1.lengthOfLongestSubsequence(List.of(1,1,5,4,5), 3));
        // 1, 2, 7, 6, 7
    }


    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int len = nums.size();
        int[] dynamicCache = new int[target + 1];

        Arrays.fill(dynamicCache, -1);
        dynamicCache[0] = 0;

        for (int i = 0; i < len; i++) {
            int num = nums.get(i);
            for (int j = target; j >= num; j--) {
                if (dynamicCache[j - num] != -1) {
                    dynamicCache[j] = Math.max(dynamicCache[j], dynamicCache[j - num] + 1);
                }
            }
        }
        return dynamicCache[target];
    }


    // not fast enough
    public int lengthOfLongestSubsequenceBacktracking(List<Integer> nums, int target) {
        Set<List<Integer>> res = new HashSet<>();
        backtrack(nums, res, target, new ArrayList<>(), 0, 0);

        int maxLength = -1;
        for (List<Integer> l : res) {
            maxLength = Math.max(maxLength, l.size());
        }
        return maxLength;
    }

    void backtrack(List<Integer> nums, Set<List<Integer>> res, int target, List<Integer> subset, int startIndex, int currentSum) {
        if (currentSum == target) {
            res.add(new ArrayList<>(subset));
        } else if (currentSum < target) {
            for (int i = startIndex; i < nums.size(); i++) {
                subset.add(nums.get(i));
                currentSum += nums.get(i);
                backtrack(nums, res, target, subset, i + 1, currentSum);
                subset.remove(subset.size() - 1);
                currentSum -= nums.get(i);
            }
        }
    }
}
