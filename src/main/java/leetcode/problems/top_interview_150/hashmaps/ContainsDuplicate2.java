package leetcode.problems.top_interview_150.hashmaps;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicate2 {
    public static void main(String[] args) {
        containsNearbyDuplicate(new int[] {1,0,1,1}, 1);
    }

    // my solution
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (map.containsKey(cur)) {
                int diff = i - map.get(cur);
                if (diff <= k) {
                    return true;
                }
            }
            map.put(cur, i);

        }

        return false;
    }

    // interesting solution from editorial
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
    }
}
