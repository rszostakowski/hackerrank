package leetcode.problems.math;

import java.util.*;

public class Sum4 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        Set<String> unique = new HashSet();
        Arrays.sort(nums);
        for (int d = 0; d < nums.length -3; d++) {

            for (int i = d+1; i < nums.length-2; i++) {
                int j = i + 1;
                int k = nums.length - 1;

                while (j < k) {
                    long sum = (long) nums[d] + (long) nums[i] + (long) nums[j] + (long) nums[k];
                    if (sum == target) {
                        String str = "" + nums[d] + nums[i] + nums[j] + nums[k];
                        if (!unique.contains(str)) {
                            ans.add(Arrays.asList(nums[d], nums[i], nums[j], nums[k]));
                            unique.add(str);
                        }

                        while (j <k && nums[j] == nums[j + 1]) {
                            j++;
                        }

                        while (j < k && nums[k] == nums[k - 1]) {
                            k--;
                        }

                        j++;
                        k--;
                    } else if (sum > target) {
                        k--;
                    } else {
                        j++;
                    }

                }

            }
        }
        return ans;
    }
}
