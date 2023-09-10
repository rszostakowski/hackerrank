package leetcode.problems.arrays;

import java.util.Arrays;

public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = new int[] {0,1,10,0,0,0, 0,3,12};
        moveZeroesShift(nums);
    }
    //https://leetcode.com/problems/move-zeroes/
    public static void moveZeroes(int[] nums) {
        int n= nums.length;
        for (int i = n-1; i >= 0; i--) {
            int val = nums[i];
            if (val == 0) {
                int k = i + 1;
                while (k < n && nums[k] != 0) {
                    nums[k-1] = nums[k];
                    k++;
                }
                nums[k-1] = 0;
            }
        }

        System.out.println(Arrays.toString(nums));
    }


    // simply brilliant solution
    public static void moveZeroesBrilliant(int[] nums) {
        int snowBallSize = 0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==0){
                snowBallSize++;
            }
            else if (snowBallSize > 0) {
                int t = nums[i];
                nums[i]=0;
                nums[i-snowBallSize]=t;
            }
        }
    }


    // Shift non-zero values as far forward as possible
    // Fill remaining space with zeros

    public static void moveZeroesShift(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int insertPos = 0;
        for (int num: nums) {
            if (num != 0) nums[insertPos++] = num;
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    // another brilliant solution
    public static void moveZeroesTwoPointers(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }
}
