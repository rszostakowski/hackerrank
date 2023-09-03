package leetcode.problems.contests.biweekly_contest_112;

import java.util.*;

public class MaximumSumOfAlmostUniqueSubarray {

    public static void main(String[] args) {
        MaximumSumOfAlmostUniqueSubarray ex3 = new MaximumSumOfAlmostUniqueSubarray();

        Integer[] nums = new Integer[] {2,6,7,3,1,7};
        int m = 3, k = 4;
        ex3.maxSum(Arrays.asList(nums), m , k);
    }

    public long maxSum(List<Integer> nums, int m, int k) {
        int n = nums.size();
        long maxSum = 0;

        Map<Integer, Integer> distinctElements = new HashMap<>();
        long currentSum = 0;
        for (int i = 0; i < n; i++) {
            int cur = nums.get(i);
            distinctElements.put(cur, distinctElements.getOrDefault(cur, 0) +1);
            currentSum += cur;

            if (i >=k) {
                int previous = nums.get(i-k);
                distinctElements.put(previous, distinctElements.get(previous) -1);
                if (distinctElements.get(previous) == 0) {
                    //System.out.println("deleting: " + previous);
                    distinctElements.remove(previous);
                }
                currentSum -= previous;
            }

            if (i >=k -1 && distinctElements.keySet().size() >= m) {
                //System.out.println("currentSum: " + currentSum);
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }

}
