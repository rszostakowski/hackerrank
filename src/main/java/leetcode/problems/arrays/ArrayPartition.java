package leetcode.problems.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayPartition {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        //System.out.println(Arrays.toString(nums));
        int sum = 0;
        for (int i = 0; i < nums.length; i+=2) {
            //System.out.println("i: " + i);
            sum += nums[i];
        }

        return sum;
    }
}
