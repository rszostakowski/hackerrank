package leetcode.problems.math;

import java.math.BigInteger;

public class ArrangingCoins {
    // the best solution can be found here:
    // https://leetcode.com/problems/arranging-coins/solutions/1559913/java-3-solutions-bit-manipulation-binary-search-math-tc-o-1-sc-o-1-beats-100/
    public int arrangeCoins(int n) {
        if (n == 1)
            return 1;

        double newN = (double) n;
        double high = Math.sqrt(newN * 2);
        high = high + 1;
        while (high > 1) {
            int highN = (int) high;
            double higher = (double) highN * (highN + 1) / 2;
            double lower = (double) highN * (highN - 1) / 2;
            if (higher > n && lower <= n) {
                return (int) high - 1;
            }
            high--;
        }

        return 1;
    }
}
