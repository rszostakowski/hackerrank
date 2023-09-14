package leetcode.problems.math;

import java.util.HashSet;
import java.util.Set;

public class PowerOfFour {
    public static void main(String[] args) {
        System.out.println(isPowerOfFour(16));
    }
    public static boolean isPowerOfFour(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(1);

        long k = 1;
        while (k * 4 < Integer.MAX_VALUE) {
            k *= 4;
            set.add((int) k);
        }

        return set.contains(n);
    }

    // absolutely brilliant
    /* https://leetcode.com/problems/power-of-four/solutions/80456/o-1-one-line-solution-without-loops/
    The basic idea is from power of 2, We can use "n&(n-1) == 0"
    to determine if n is power of 2. For power of 4, the additional restriction
    is that in binary form, the only "1" should always located at the odd position.
     For example, 4^0 = 1, 4^1 = 100, 4^2 = 10000. So we can use "num & 0x55555555==num"
     to check if "1" is located at the odd position.
     */
    public boolean isPowerOfFour_bit(int num) {
        return (num > 0) && ((num & (num - 1)) == 0) && ((num & 0x55555555) == num);
    }

    // another brilliant solution:
    //https://leetcode.com/problems/power-of-four/solutions/80460/1-line-c-solution-without-confusing-bit-manipulations/
    /*
    (4^n - 1) % 3 == 0
        another proof:
        (1) 4^n - 1 = (2^n + 1) * (2^n - 1)
        (2) among any 3 consecutive numbers, there must be one that is a multiple of 3
        among (2^n-1), (2^n), (2^n+1),
        one of them must be a multiple of 3,
        and (2^n) cannot be the one, therefore either
        (2^n-1) or (2^n+1) must be a multiple of 3, and 4^n-1 must be a multiple of 3 as well.
     */

    public boolean isPowerOfFour_Brilliant(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num - 1) % 3 == 0;
    }
}
