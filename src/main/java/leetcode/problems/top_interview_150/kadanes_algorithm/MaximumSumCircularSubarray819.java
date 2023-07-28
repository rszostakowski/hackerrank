package leetcode.problems.top_interview_150.kadanes_algorithm;

import org.testng.Assert;
import org.testng.annotations.Test;


public class MaximumSumCircularSubarray819 {

    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int twoN =  2* nums.length;

        int currentMax = 0;
        int currentSum = 0;

        for (int i = 0; i < twoN-1; i++) {
            int idx = i % n;
            currentSum += nums[idx];
            currentMax = Math.max(currentMax, currentSum);
            if (currentSum < 0) {
                currentSum = 0;
            }
        }


        return currentMax;

    }

    @Test
    public void test() {
        // 5 2 7 12 9 14
        Assert.assertEquals(maxSubarraySumCircular(new int[]{5, -3, 5,  5, -3}), 10);

        // 5 -5 4 3     5
        // 5 0  4 7     12
    }
}
