package leetcode.problems.contests.biweekly_contest_119;

import java.util.HashMap;
import java.util.Map;

public class Ex3 {
    public static void main(String[] args) {
        Ex3 ex = new Ex3();
        if (ex.maxSubarrayLength(new int[] {5,5,5,5,5,5,5, 1,2,3,1,2,3,1,2}, 2) != 8) {
            throw new RuntimeException("-1");
        };

        if (ex.maxSubarrayLength(new int[] {2,1,1,3}, 1) != 2) {
            throw new RuntimeException("0");
        };
        if (ex.maxSubarrayLength(new int[] {1,2,3,1,2,3,1,2}, 2) != 6) {
            throw new RuntimeException("1");
        };
        if (ex.maxSubarrayLength(new int[] {1,2,1,2,1,2,1,2}, 1) != 2) {
            throw new RuntimeException("2");
        };
        if (ex.maxSubarrayLength(new int[] {5,5,5,5,5,5,5}, 4) != 4) {
            throw new RuntimeException("3");
        };
        if (ex.maxSubarrayLength(new int[] {0}, 1) != 1) {
            throw new RuntimeException("4");
        };
        if (ex.maxSubarrayLength(new int[] {}, 1) != 0) {
            throw new RuntimeException("5");
        };
        if (ex.maxSubarrayLength(new int[] {4,4,4,4,4,4}, 44) != 6) {
            throw new RuntimeException("5");
        };
    }
    public int maxSubarrayLength(int[] nums, int k) {
        int longest = 0;
        int right = 0;
        int left = 0;
        Map<Integer, Integer> occur = new HashMap<>();

        while(right< nums.length) {
            int num = nums[right];
            int newFreq = occur.getOrDefault(num, 0) + 1;
            if (newFreq <=k) {
                occur.put(num, occur.getOrDefault(num, 0) + 1);
            } else {
                int toRemove = nums[left++];
                if (occur.get(toRemove) == 1) {
                    occur.remove(toRemove);
                } else {
                    occur.put(toRemove, occur.get(toRemove) - 1);
                }
                continue;
            }
            longest = Math.max(longest, right - left +1);
            right++;
        }
        return longest;
    }
}
