package leetcode.problems.arrays;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.reverse;

public class CountNicePairsInAnArray {
    public static void main(String[] args) {
        int[] nums = {42,11,1,97};
        countNicePairs(nums);
    }
    public static int countNicePairs(int[] nums) {
        long counter = 0;
        Map<Long, Long> occur = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long numI = nums[i];
            long revNumI =reverseIn(numI);
            long diff = revNumI - numI;
            occur.put(diff, occur.getOrDefault(diff, 0l) +1);
        }

        for (long count : occur.values()) {
            counter = (counter + (count * (count - 1) / 2)) ;
        }

        return (int) (counter % (Math.pow(10, 9) + 7));
    }

    private static long reverseIn(long num) {
        long reverse = 0;
        for( ;num != 0; num=num/10)
        {
            long remainder = num % 10;
            reverse = reverse * 10 + remainder;
        }

        return reverse;
    }
}
