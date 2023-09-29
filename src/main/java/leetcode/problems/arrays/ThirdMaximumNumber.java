package leetcode.problems.arrays;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/third-maximum-number/description/
public class ThirdMaximumNumber {

    public static void main(String[] args) {
        int[] nums = {1,-2147483648,2};
        thirdMax(nums);
    }

    // my solution
    public static int thirdMax(int[] nums) {

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        boolean thirdWasFound = false;
        Set<Integer> unique = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (!thirdWasFound){
                unique.add(val);
                if (unique.size() ==3){
                    thirdWasFound = true;
                }
            }

            if (val > first) {
                third = second;
                second = first;
                first = val;
            } else if (val > second && val != first) {
                third = second;
                second = val;
            } else if (val >= third && val != second&& val != first) {
                third = val;
            }
        }


        if (thirdWasFound)
            return third;

        return first;
    }

    // the best solution:
    // similar to mine, better written in a better way
    public int thirdMaxBest(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for (Integer n : nums) {
            if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;
            if (max1 == null || n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (max2 == null || n > max2) {
                max3 = max2;
                max2 = n;
            } else if (max3 == null || n > max3) {
                max3 = n;
            }
        }
        return max3 == null ? max1 : max3;
    }
}
