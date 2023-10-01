package leetcode.problems.contests.biweekly_contest_114.biweekly_contest_113;

import java.util.*;

public class Solution2 {

    public static void main(String[] args) {

        //int[] nums = {2,3,3,2,2,4,2,3,4};
        int[] nums = {3};
        System.out.println(minOperations(nums));
    }
    public static int minOperations(int[] nums) {
        Map<Integer, Integer> occur = new HashMap<>();
        for (int num : nums) {
            occur.put(num, occur.getOrDefault(num, 0) +1);
        }
        int operations = 0;
        Set<Map.Entry<Integer, Integer>> entries = occur.entrySet();
        for (Map.Entry<Integer, Integer> entry: entries) {
            Integer val = entry.getValue();
            while (val > 1) {
                if (val == 3) {
                    val = 0;
                } else if (val == 2) {
                    val = 0;
                } else if (val == 4) {
                    val -= 2;
                } else if (val == 5) {
                    val -= 3;
                } else {
                    val -= 3;
                }
                operations++;
            }
            entry.setValue(val);
        }

        HashSet<Integer> reduced = new HashSet<>(occur.values());
        if (reduced.size() == 1 && reduced.contains(0)) {
            return operations;
        }
        return -1;
    }
}
