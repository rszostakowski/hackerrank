package leetcode.problems.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String gold  = "Gold Medal";
        String silver  = "Silver Medal";
        String bronze  = "Bronze Medal";

        int[] sorted = Arrays.copyOf(score, n);
        Arrays.sort(sorted);

        Map<Integer, String> map = new HashMap();
        for (int i = n-1; i >= 0; i--) {

            if (i == n-1) {
                map.put(sorted[i], gold);
            } else if (i == n-2) {
                map.put(sorted[i], silver);
            } else if (i == n-3) {
                map.put(sorted[i], bronze);
            } else {
                map.put(sorted[i], ""+ (n - i));
            }
        }

        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = map.get(score[i]);
        }

        return result;
    }
}
