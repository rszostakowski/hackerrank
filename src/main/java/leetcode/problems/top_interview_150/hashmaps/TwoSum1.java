package leetcode.problems.top_interview_150.hashmaps;

import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> missing = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            int toFind = target - i;
            if (missing.containsKey(toFind)) {
                return new int[] { missing.get(toFind), i};
            } else {
                missing.put(nums[i], i);
            }
        }

        return new int[0];
    }
}
