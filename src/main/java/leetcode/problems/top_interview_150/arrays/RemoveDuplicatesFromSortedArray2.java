package leetcode.problems.top_interview_150.arrays;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray2 {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        removeDuplicates(nums);
    }
    public static int removeDuplicates(int[] nums) {
        if (nums.length >1) {
            int index = 2;
            int prevPrev = nums[0];
            int prev = nums[1];
            for (int i = 2; i < nums.length; i++) {
                System.out.println("prevPrev: " + prevPrev + " prev: " + prev + " nums[i]: " + nums[i]);
                if (nums[i] != prev || nums[i] != prevPrev) {
                    nums[index++] = nums[i];
                    prevPrev = prev;
                    prev = nums[i];
                }
            }
            System.out.println(Arrays.toString(nums));
            return index;
        }
        return nums.length;
    }

    // best solution from comments
    public int removeDuplicates2(int[] nums) {
        int j=1;
        for(int i=2;i<nums.length;i++)
            if(nums[i]!=nums[j-1])
                nums[++j]=nums[i];
        return j+1;
    }

}
