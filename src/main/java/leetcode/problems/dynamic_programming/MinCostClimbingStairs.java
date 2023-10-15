package leetcode.problems.dynamic_programming;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] db = new int[len];
        db[0] = cost[0];
        db[1] = cost[1];

        for(int i = 2; i < len; i++) {
            db[i] = cost[i] + Math.min(db[i-2], db[i-1]);
        }

        return Math.min(db[len-1], db[len-2]);
    }

    // the best solution
    public int minCostClimbingStairs_best(int[] cost) {
        int one = 0;
        int two = 0;

        for (int i = cost.length - 1; i >= 0; i--) {
            cost[i] += Math.min(one, two);
            two = one;
            one = cost[i];
        }

        return Math.min(cost[0], cost[1]);
    }
}
