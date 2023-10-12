package leetcode.problems.arrays;

import java.util.HashMap;
import java.util.Map;

public class NextGreaterElement1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap();

        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }

        for (int i = 0; i < nums1.length; i++) {
            res[i] = -1;
            int current = nums1[i];
            for (int j = map.get(current) + 1; j < nums2.length; j++) {
                if (nums2[j] > current) {
                    res[i] = nums2[j];
                    break;
                }
            }
        }
        return res;
    }
}
