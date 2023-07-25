package leetcode.problems.top_interview_150.arrays;

import java.util.Arrays;

public class RemoveElement27 {
    public int removeElement(int[] nums, int val) {
        int counter = 0;
        int n =  nums.length;

        for (int i = n-1; i >=0 ; i--) {
            if (nums[i] == val) {
                counter++;
                nums[i] = 51;
            }
        }

        Arrays.sort(nums);
        return n - counter;
    }


    public static int removeElementAlternative(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int val = 2;
        int[] nums = new int[] { 3,2,2,3 };
        removeElementAlternative(nums, val);

    }
}
