package leetcode.problems.top_interview_150.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;

        rotate(nums, k);
    }
    // my solution
    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        int move = k % n;

        int[] temp = new int[move];
        int idx = 0;
        for (int i = n - move; i < n; i++) {
            temp[idx++] = nums[i];
        }

        for (int i = n-1; i >= move; i--) {
            nums[i] = nums[i-move];
        }

        for (int i = 0; i < move; i++) {
            nums[i] = temp[i];
        }
    }


    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        reverse(nums, 0, k - 1);
        System.out.println(Arrays.toString(nums));
        reverse(nums, k, nums.length - 1);
        System.out.println(Arrays.toString(nums));

    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
