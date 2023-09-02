package leetcode.problems.arrays;

import java.util.HashMap;
import java.util.Map;

public class NumberOfGoodPairs {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> occur = new HashMap();
        for (int num: nums) {
            occur.put(num, occur.getOrDefault(num, 0) +1);
        }

        int sum = 0;
        for (int key: occur.keySet()) {
            sum += combinations(occur.get(key));
        }

        return sum;
    }

    public int combinations(int n) {
        return n * (n-1) / 2;
    }
}
