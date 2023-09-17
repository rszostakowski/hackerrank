package leetcode.problems.contests.biweekly_contest_113;

import java.util.*;

public class Solution2 {

    // TODO it did not work...

    public static void main(String[] args) {
        //[1,1,2,3,4,4]
        //[2,3,4,4,4]
        //[1,1,1,2,3]
        //[1,2,3,3,3,4,5]
        // 1,2,3,4,5

        //[1,2,2,3,3,3,4,4,5]
        // 1,2,3,4,5
        // [2,3,3,4]
        char[] chars = new char[2];

        List<Integer> nums = new LinkedList<>();
        nums.add(1);
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(4);

//        List<Integer> nums = new LinkedList<>();
//        nums.add(1);
//        nums.add(1);
//        nums.add(3);
        minLengthAfterRemovals(nums);
    }
    public static int minLengthAfterRemovals(List<Integer> nums) {
        // 1, 1, 1,1,2

        Map<Integer, Integer> occur = new HashMap<>();
        for (int num : nums) {
            occur.put(num, occur.getOrDefault(num, 0) +1);
        }

        int maxValue = Integer.MIN_VALUE;
        int maxKey = -1;

        // Iterate through the map to find the maximum value and its key
        for (Map.Entry<Integer, Integer> entry : occur.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if (value > maxValue) {
                maxValue = value;
                maxKey = key;
            }
        }

        int idx = nums.indexOf(maxKey);
        if (idx > 0) {
            idx -=1;
        }
        while(idx + 1 < nums.size()) {
            if (nums.get(idx) != nums.get(idx+1)) {
                nums.remove(idx);
                nums.remove(idx);
                if (idx >1)
                    idx -= 1;
                else
                    idx = 0;
            } else {
                idx++;
            }
        }

        return nums.size();

        //int left = 0;
        //int right = 0;
       // int n = nums.size();
//        HashSet<Integer> integers = new HashSet<>(nums);
//        integers.size();
/*        int idx = 0;



        int idx2 = nums.size()-2;
        while(idx2 >= 0) {
            if (nums.get(idx2) != nums.get(idx2+1)) {
                nums.remove(idx);
                nums.remove(idx);
                if (idx <1)
                    idx -= 1;
                else
                    idx = 0;
            } else {
                idx++;
            }
        }

        return nums.size();*/
    }
}
