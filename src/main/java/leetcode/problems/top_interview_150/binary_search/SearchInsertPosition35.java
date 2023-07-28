package leetcode.problems.top_interview_150.binary_search;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchInsertPosition35 {
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int length = nums.length;
        int right = length;
        int mid = 0;

        if (target <= nums[0]) {
            return 0;
        }

        if (target > nums[length-1]) {
            return length;
        }

        while (left < right) {
            //mid = left + (left + right) /2;
            mid = (left + right) /2;
            System.out.println("mid: " + mid);

            int val = nums[mid];
            if (nums[mid -1] < target && target <= val)
            {
                System.out.println("returning the val");
                return mid;
            }

            if (val < target) {
                left = mid;
            }
            if (val > target) {
                right = mid;
            }

        }

        return mid;
    }

    // even better solution from the comments section
    public int searchInsertAlt(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        while (start <= end) {
            int mid = start + (end-start)/2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) end = mid-1;
            else start = mid+1;
        }

        return start;
    }

    @Test
    public void test1() {
        Assert.assertEquals(searchInsert(new int[]{1,3,5,6}, 5), 2);
    }
    @Test
    public void test2() {
        Assert.assertEquals(searchInsert(new int[]{1,3,5,6}, 2), 1);
    }
    @Test
    public void test3() {
        Assert.assertEquals(searchInsert(new int[]{1,3,5,6}, 7), 4);
    }

    @Test
    public void test4() {
        Assert.assertEquals(searchInsert(new int[]{1,3,5,6}, 6), 3);
    }
}
