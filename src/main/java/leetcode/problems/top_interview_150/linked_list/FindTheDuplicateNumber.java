package leetcode.problems.top_interview_150.linked_list;

import java.util.HashSet;

public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            }
            set.add(nums[i]);
        }
        throw new RuntimeException();
    }

    // best solution from the internet
    public int findDuplicateBest(int[] nums) {
        int slow = 0;
        int fast = 0;
        int n = nums.length;

        do {
            System.out.println("slow: " + slow + " fast: " + fast);
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        System.out.println("Found: slow: " + slow + " fast: " + fast);

        int slow2 = 0;

        do {
            System.out.println("slow: " + slow + " fast: " + fast);
            slow = nums[slow];
            slow2 = nums[slow2];
        } while (slow != slow2);

        return slow2;
    }
}
