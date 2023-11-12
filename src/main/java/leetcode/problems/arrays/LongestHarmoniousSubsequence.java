package leetcode.problems.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LongestHarmoniousSubsequence {
    public static void main(String[] args) {
        int[] nums = {1,3,2,2,5,2,3,7};
        findLHS(nums);
    }
    public static int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        Set<Integer> keys = map.keySet();

        int max = Integer.MIN_VALUE;
        for (int key: keys) {
            int prev = key -1;
            int next = key +1;
            int left = getSeq(map, key, prev);
            int right = getSeq(map, key, next);

            max = Math.max(max, Math.max(left, right));
        }
        return max;
    }

    private static int getSeq(Map<Integer, Integer> map, int key, int prev) {
        Integer local = map.getOrDefault(prev, 0);
        if (local == null  || local == 0) {
            return 0;
        }
        return map.get(key) + local;
    }
}
