package leetcode.problems.arrays;

import java.util.*;

public class Pattern132 {
    public static void main(String[] args) {
        Pattern132 p = new Pattern132();
        int[] nums = {-2,1,2,-2,1,2};
        System.out.println(p.find132pattern(nums));
    }

    // my solution - overkill
    public boolean find132pattern(int[] nums) {
        int n = nums.length;

        if (n < 3) {
            return false;
        }

        List<Integer> reduced = new ArrayList();
        TreeMap<Integer, Integer> right = new TreeMap<>();
        TreeMap<Integer, Integer> left = new TreeMap<>();
        reduced.add(nums[0]);
        left.put(nums[0], 1);

        for (int i = 1; i< n; i++) {
            int val = nums[i];
            if (nums[i-1] != val) {
                reduced.add(val);
                right.put(val, right.getOrDefault(val, 0) +1);
            }
        }

        n = reduced.size();
        if (n < 3) {
            return false;
        }
        for (int i = 1; i< n; i++) {
            int val = reduced.get(i);
            Integer keeped = right.get(val);
            if (keeped == 1) {
                right.remove(val);
            } else {
                right.put(val, keeped-1);
            }

            Integer minLeft = left.firstKey();
            Integer minRight = right.lowerKey(val);
            if (minRight != null && minLeft < val && val > minRight && minLeft < minRight) {
                return true;
            }
            left.put(val, left.getOrDefault(val, 0) +1);
        }
        return false;
    }

    //best
    public boolean find132pattern_best(int[] nums) {
        int s3 = Integer.MIN_VALUE;
        Stack<Integer> st = new Stack<Integer>();
        for( int i = nums.length-1; i >= 0; i -- ){
            if( nums[i] < s3 ) return true;
            else while(!st.empty() && nums[i] > st.peek()){
                s3 = st.peek();
                st.pop();
            }
            st.push(nums[i]);
        }
        return false;
    }
}
