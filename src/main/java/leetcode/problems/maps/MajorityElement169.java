package leetcode.problems.maps;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement169 {

    public int majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> occur = new HashMap();

        for (int i = 0; i <n; i++) {
            int el = nums[i];
            int current = occur.getOrDefault(el, 0) + 1;
            if (current > n/2) {
                return el;
            }
            occur.put(el, current);
        }

        return -1;
    }

    // THE BEST Moore Voting Algorithm TODO really interesting https://leetcode.com/problems/majority-element/solutions/3676530/3-method-s-beats-100-c-java-python-beginner-friendly/
    public int majorityElement2(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }

}
