package leetcode.problems.top_interview_150.hashmaps;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    //https://leetcode.com/problems/longest-consecutive-sequence/description/
    //  O(n log n + n) but good enough
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int msf = 1;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i-1] +1 == nums[i]) {
                msf++;
            } else if ( i > 0 && nums[i-1] == nums[i] ){
                continue;
            } else {
                msf = 1;
            }

            ans = Math.max(ans, msf);
        }

        return ans;
    }

    // nice solution but it seems to be o(n^2) but
    // The inner loop is based on a conditional that does not occur n times in an average case so you would not consider it a nested loop.
    public int longestConsecutive2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums) {
            set.add(n);
        }
        int best = 0;
        for(int n : set) {
            if(!set.contains(n - 1)) {  // only check for one direction
                int m = n + 1;
                while(set.contains(m)) { // this is a nice treak!
                    m++;
                }
                best = Math.max(best, m - n);
            }
        }
        return best;
    }
}
