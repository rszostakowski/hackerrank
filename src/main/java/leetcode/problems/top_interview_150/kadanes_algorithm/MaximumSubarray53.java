package leetcode.problems.top_interview_150.kadanes_algorithm;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class MaximumSubarray53 {

    public static void main(String[] args) {
        int[] nums = new int[] {-2, -1};
        maxSubArray(nums);
    }


    // I am sure there is a better solution than mine below
    // correct but not the best
    public static int maxSubArrayWorst(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }
        int[] summed = new int[n];


        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int dist = Integer.MIN_VALUE;
        for (int i = 0; i <n ; i++) {
            int current =  nums[i];
            if (i > 0) {
                current += summed[i-1];
            }
            summed[i] = current;
            if (current < min) {
                min = current;
                max = current;
            }

            if (current > max) {
                max = current;
                dist = Math.max(dist, max - Math.min(min, 0));
            } else {
                dist = Math.max(dist, nums[i]);
            }


            System.out.println("max: " + max + " min: "+  min + " dist: " + dist);
        }

        System.out.println(Arrays.toString(summed));
        return dist;

    }

    // correct but verbose
    public static int maxSubArray2(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            if (currentSum > maxSum) {
                maxSum = currentSum;
            }

            if (currentSum < 0) {
                currentSum = 0;
            }

            System.out.println("maxSum: " + maxSum + " currentSum " + currentSum);
        }

        return maxSum;
    }

    // The best
    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    @Test
    public void test() {
        Assert.assertEquals(maxSubArray(new int[] { -5,-5,-5,-5,11, 9, -5, -5, 5, -25}), 20);
 /*        Assert.assertEquals(maxSubArray(new int[] {0,-3,1,1}), 2);
       Assert.assertEquals(maxSubArray(new int[] {-3, -2, -1}), -1);
        Assert.assertEquals(maxSubArray(new int[] {-3, 2, 1}), 3);
        Assert.assertEquals(maxSubArray(new int[] { -2,1,-3,4,-1,2,1,-5,4}), 6);

        Assert.assertEquals(maxSubArray(new int[] { 5,4,-1,7,8}), 23);*/
    }

}
