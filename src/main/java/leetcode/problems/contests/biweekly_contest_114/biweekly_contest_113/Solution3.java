package leetcode.problems.contests.biweekly_contest_114.biweekly_contest_113;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution3 {

    public static void main(String[] args) {
        //int[] nums = {1,0,2,0,1,2};
        //int[] nums = {5,7,1,3};
        //int[] nums = {30,18,19,20,11,21,12,22,26};
        int[] nums = {18,12,16,28,7,15,24,7,8,26,22,6,23,7,17,1,16}; //6
        //int[] nums = {1,1,1,1};
        //int[] nums = {0, 0};
        System.out.println(maxSubarrays(nums));
    }
    public static int maxSubarrays(int[] nums) {

        int maxScore = calculateScore(nums);
        boolean left = false;
        int component = 0;
        BigInteger sum = null;

        for (int desired = 0; desired <= maxScore; desired++) {
            for (int i = 0; i < nums.length; i++) {
                if (!left && nums[i] == desired) {
                    component++;
                } else if (sum == null) {
                    sum = new BigInteger(Integer.toBinaryString(nums[i]));
                    left = true;
                } else {
                    sum = sum.and(new BigInteger(Integer.toBinaryString(nums[i]), 2));
                    left = true;
                    if (sum.intValue() == desired) {
                        component++;
                        sum = null;
                        left = false;
                    }
                }
            }

            if (sum == null) {
                return component+1;
            } else if (component > 1 && maxScore ==0) {
                return component;
            }
        }
        return 1;
    }

    private static int calculateScore(int[] subarray) {
        BigInteger sum = new BigInteger(Integer.toBinaryString(subarray[0]), 2);
        for (int i = 1; i < subarray.length; i++) {
            String next = Integer.toBinaryString(subarray[i]);
            sum = sum.and(new BigInteger(next, 2));
        }

        return sum.intValue();
    }
}
