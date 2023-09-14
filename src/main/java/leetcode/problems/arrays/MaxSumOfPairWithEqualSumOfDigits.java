package leetcode.problems.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxSumOfPairWithEqualSumOfDigits
{
    public int maximumSum(int[] nums) {
        int n = nums.length;

        Map<Integer, Integer> occur = new HashMap();
        int max = -1;
        for (int num : nums) {
            int summedUp = sumDigits(num);
            if (occur.containsKey(summedUp)) {
                int current = occur.get(summedUp);
                max = Math.max(max, current + num);
                if (current < num) {
                    occur.put(summedUp, num);
                }
            } else {
                occur.put(summedUp, num);
            }
        }
        return max;
    }

    public int sumDigits(int num) {
        int summed = 0;
        while(num >0) {
            int mod = num % 10;
            summed += mod;
            num /= 10;
        }
        return summed;
    }
}
