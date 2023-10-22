package leetcode.problems.contests.biweekly_contest_113;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args) {
        List<Integer> nums = new LinkedList<>();
        nums.add(2);
        nums.add(1);
        nums.add(4);
        minimumRightShifts(nums);
    }
    public static int minimumRightShifts(List<Integer> nums) {
        int n = nums.size();
        boolean alreadySorted = true;
        int smallestEl = Integer.MAX_VALUE;
        int smallestIdx = -1;

        for (int i = 0; i <n-1; i++) {
            if (nums.get(i) > nums.get(i+1)) {
                alreadySorted = false;
            }
        }

        if (alreadySorted) {
            return 0;
        }

        for (int i = 0; i <n; i++) {
            if (nums.get(i) < smallestEl) {
                smallestEl = nums.get(i);
                smallestIdx = i;
            }
        }

        int shifts = n - smallestIdx;

        int[] array = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            array[i] = nums.get(i);
        }

        int[] copied = `Arrays.copyOf(`array, n);
        Arrays.sort(copied);

        rotate(array, shifts);
        if (Arrays.equals(copied, array)) {
            return shifts;
        }
        return -1;
    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        int move = k % n;

        int[] temp = new int[move];
        int idx = 0;
        for (int i = n - move; i < n; i++) {
            temp[idx++] = nums[i];
        }

        for (int i = n-1; i >= move; i--) {
            nums[i] = nums[i-move];
        }

        for (int i = 0; i < move; i++) {
            nums[i] = temp[i];
        }
    }
}
