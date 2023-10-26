package leetcode.problems.arrays;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class MaximumScoreOfGoodSubarray {
//https://leetcode.com/problems/maximum-score-of-a-good-subarray/

    public int maximumScore(int[] nums, int k) {
        int left = k -1;
        int n = nums.length;
        int[] mins = new int[n];

        mins[k] = nums[k];
        while(left >= 0) {
            mins[left] = Math.min(nums[left], mins[left+1]);
            left--;
        }

        int right = k+1;
        while(right < n) {
            mins[right] = Math.min(nums[right], mins[right-1]);
            right++;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i<=k; i++) {
            if (i>0 && mins[i-1]== mins[i]) {
                continue;
            } else {
                for (int rightPart = k; rightPart < n; rightPart++) {
                    int min = Math.min(mins[i], mins[rightPart]);
                    int score = (rightPart - i + 1) * min;
                    max = Math.max(score, max);
                }
            }
        }

        return max;
    }

    // the best solution: https://leetcode.com/problems/maximum-score-of-a-good-subarray/solutions/1108260/c-greedy-o-n/
}
