package leetcode.problems.binary_search;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }

        int left = 0;
        int right = n;

        int count = 0;
        while (left <= right && count < 30) {
            int mid = (left + right)/2;
            int midVal = nums[mid];

            if (midVal == target) {
                return mid;
            }

            if (midVal < target) {
                left = mid;
            } else {
                right = mid;
            }
            count++;
        }

        return -1;
    }
}
