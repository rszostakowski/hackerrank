package leetcode.problems.arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class IntersectionOfTwoArrays2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int left = 0;
        int right = 0;

        List<Integer> res = new LinkedList();
        while (left < n1 && right < n2) {
            if (nums1[left] == nums2[right]) {
                res.add(nums1[left]);
                left++;
                right++;
            } else if (nums1[left] < nums2[right]) {
                left++;
            } else {
                right++;
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
