package leetcode.problems.top_interview_150.sliding_window;

import java.util.Arrays;

public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(11, new int[] {1,2,3,4,5}));
        //System.out.println(minSubArrayLen(7, new int[] {2,3,1,2,4,3}));
    }

    // my solution - not optimal
    public static int minSubArrayLen2(int target, int[] nums) {
        int n = nums.length;
        int smallest = Integer.MAX_VALUE;
        for (int wLen=n; wLen >= 0; wLen--) {
            int slidingWindow = 0;
            boolean found = false;
            for (int i=0; i < nums.length; i++) {
                if (i >= wLen) {
                    slidingWindow -= nums[i-wLen];
                }
                slidingWindow += nums[i];
                if (slidingWindow >= target) {
                    found = true;
                    smallest = Math.min(wLen, smallest);
                }
            }
            if (!found)  {
                break;
            }
        }
        if (smallest == Integer.MAX_VALUE) {
            return 0;
        }
        return smallest;
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0;
        int smallest = Integer.MAX_VALUE;
        int s = 0;
        for (int i=0; i < n; i++) {
            s += nums[i];

            while (s>= target ) {
                System.out.println(s);
                smallest = Math.min(smallest, i - left + 1);
                s -= nums[left];
                left++;
            }


        }
        return smallest == Integer.MAX_VALUE ? 0: smallest;
    }
}
