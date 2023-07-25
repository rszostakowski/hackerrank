package leetcode.problems.top_interview_150.arrays;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int index = 1;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != prev) {
                nums[index++] = nums[i];
                prev = nums[i];
            }
        }
        return index;
    }
}
