package leetcode.problems.arrays;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindAllNumbersDisappearedInAnArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;

        Set<Integer> missing = new HashSet();
        for (int i = 0; i < n; i++) {
            missing.add(i+1);
        }

        for (int i = 0; i < n; i++) {
            missing.remove(nums[i]);
        }

        return missing.stream().collect(Collectors.toList());
    }

    // the most clever solution
    //https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/solutions/1583741/time-o-n-space-o-1/
}
