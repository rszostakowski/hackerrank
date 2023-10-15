package leetcode.problems.dynamic_programming;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ClimbingStairs {
    static int[] cache = new int[46];
    static {
        cache[1] = 1;
        cache[2] = 2;
    }

    public int climbStairs(int n) {
        if (cache[n] != 0) {
            return cache[n];
        }

        cache[n] = climbStairs(n-1) + climbStairs(n);
        return cache[n];
    }
    /*

n=2
1. 1 step + 1 step
2. 2 steps

    n=3
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

    n=4
1. 1 step + 1 step + 1 step + 1 +steps
2. 1 step + 2 steps + 1 step
3. 2 steps + 1 step + 1 step
4. 1 steps + 1 step + 2 steps
5. 2 steps + 2 steps
*/

}
