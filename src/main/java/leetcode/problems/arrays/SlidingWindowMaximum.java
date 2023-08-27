package leetcode.problems.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] nums = {7,2,4};
        int k = 2;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1)
            return nums;
        int left = 0;
        int right = k;

        int n = nums.length;
        int [] res = new int[n-k+1];
        int[] maxSoFar = new int[2];
        int counter = 0;
        while (right <= n) {
            int leftMinus1 = left -1;
            if (left == 0) {
                System.out.println("Calculating the whole subarray");
                maxSoFar = findMax(nums, left, right);
                res[counter] = maxSoFar[0];
            } else if (nums[leftMinus1] == maxSoFar[0]) {
                res[counter] = maxSoFar[1];
                maxSoFar[0] = maxSoFar[1];
            }


            if (maxSoFar[0] <nums[right-1]) {
                maxSoFar[0] = nums[right-1];
            } else if (maxSoFar[1] <nums[right-1]) {
                maxSoFar[1] = nums[right-1];
            }
            res[counter] = maxSoFar[0];

            left++;
            right++;
            counter++;
        }

        return res;
    }

    public static int[] findMax(int[] nums, int left, int right) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int i = left; i < right; i++) {
            if (nums[i] >= max) {
                secondMax = max;
                max = nums[i];
            }
        }

        return new int[] {max, secondMax};
    }


    public int[] maxSlidingWindowAlternative(int[] nums, int k) {
        if (k == 1)
            return nums;

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int idx = 0;
        while (idx < k) {
            queue.add(nums[idx]);
            idx++;
        }

        int n = nums.length;
        int[] res = new int[n - k + 1];

        while (idx <= n) {
            int top = queue.peek();
            res[idx-k] = top;
            queue.remove(nums[idx - k]);
            if (idx != n)
                queue.add(nums[idx]);
            idx++;
        }

        return res;
    }
}
