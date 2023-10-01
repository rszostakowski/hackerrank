package leetcode.problems.contests.biweekly_contest_114.biweekly_contest_113;

import java.util.*;

public class Solution1 {
    public static int minimumRightShifts(List<Integer> nums, int k) {

        int n = nums.size();

        Set<Integer> results = new HashSet<>();
        for (int i = 1; i <=k; i++) {
            results.add(i);
        }

        for (int i = n-1; i >=0; i--) {
            results.remove(nums.get(i));
            if (results.size() == 0) {
                return n-i;
            }
        }
        return n;
    }

}
