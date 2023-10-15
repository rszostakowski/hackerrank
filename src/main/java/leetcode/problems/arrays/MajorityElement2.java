package leetcode.problems.arrays;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MajorityElement2 {
    public static void main(String[] args) {
        MajorityElement2 me = new MajorityElement2();
        int[] nums = {3,2,2,2,3};
        me.majorityElement(nums);
    }
    public List<Integer> majorityElement(int[] nums) {
            int n = nums.length;
            List<Integer> res = new LinkedList();
            if (n == 1) {
                res.add(nums[0]);
                return res;
            }
            if (n == 2) {
                if (nums[0] == nums[1]) {
                    res.add(nums[0]);
                    return res;
                } else {
                    res.add(nums[0]);
                    res.add(nums[1]);
                    return res;
                }
            }
            int majority = (int) Math.floor(n / 3);
            Map<Integer, Integer> map = new HashMap();

            for (int i = 0; i < n; i++) {
                int val = nums[i];
                map.put(val, map.getOrDefault(val, 0) + 1);
            }


            for (Integer key : map.keySet()) {
                Integer val = map.get(key);
                if (val > majority) {
                    res.add(key);
                }
            }

            return res;
        }
    }

