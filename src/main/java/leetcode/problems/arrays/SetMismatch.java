package leetcode.problems.arrays;

import java.util.HashSet;
import java.util.Set;

public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] res = new int[2];
        int sum = n * (n+1)/2;
        Set<Integer> set = new HashSet();
        for (int i = 0; i <n; i++) {
            int val = nums[i];
            if (!set.contains(val)) {
                set.add(val);
                sum -= val;
            } else {
                res[0]=val;
            }
        }
        res[1] =sum;
        return res;
    }
}
