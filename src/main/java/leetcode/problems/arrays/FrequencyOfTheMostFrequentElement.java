package leetcode.problems.arrays;

import java.util.*;
import java.util.stream.Collectors;

public class FrequencyOfTheMostFrequentElement {
    public static void main(String[] args) {
//        int[] nums = {9930,9923,9983,9997,9934,9952,9945,9914,9985,9982,9970,9932,9985,9902,9975,9990,9922,9990,9994,9937,9996,9964,9943,9963,9911,9925,9935,9945,9933,9916,9930,9938,10000,9916,9911,9959,9957,9907,9913,9916,9993,9930,9975,9924,9988,9923,9910,9925,9977,9981,9927,9930,9927,9925,9923,9904,9928,9928,9986,9903,9985,9954,9938,9911,9952,9974,9926,9920,9972,9983,9973,9917,9995,9973,9977,9947,9936,9975,9954,9932,9964,9972,9935,9946,9966};
//        int k = 3056;
        int[] nums = {1,1,1,1,1,1,1,1,21};
        int k = 4;
//        int[] nums = {1,1,1,1,2,2,2,2};
 //       int k = 4;
        maxFrequency(nums, k);
    }
    public static int maxFrequency2(int[] nums, int k) {
        int max = 0;
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            int j = i-1;
            int counter = 1;
            int toUse = k;
            while (j>=0 && nums[i] - nums[j] <= toUse) {
                toUse -= (nums[i] - nums[j]);
                counter++;
                j--;
            }
            max = Math.max(max, counter);
        }

        return max;
    }
    public static int maxFrequency(int[] nums, int k) {

        Map<Integer, Integer> occur = new HashMap();
        for (int num : nums) {
            occur.put(num, occur.getOrDefault(num, 0) +1);
        }

        List<Integer> sorted = occur.keySet().stream().sorted().collect(Collectors.toList());
        int max = 0;
        for (int num : sorted) {
            max = Math.max(max, occur.get(num));
        }
        for (int i = 1; i < sorted.size(); i++) {
            int j = i-1;
            Integer numI = sorted.get(i);
            int counter = occur.get(numI);
            int toUse = k;
            while (j >= 0
                    && numI - sorted.get(j) <= toUse) {
                Integer numJ = sorted.get(j);
                Integer val = occur.get(numJ);
                int diff = numI - numJ;
                while(toUse >= diff && val >=1) {
                    toUse -= diff;
                    counter++;
                    val--;
                }
                j--;
            }
            max = Math.max(max, counter);
        }

        System.out.println(max);
        return max;
    }


}
