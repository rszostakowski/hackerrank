package leetcode.problems.arrays;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int i = len - 3;

        int[] db = new int[len];
        db[len - 1] = cost[len - 1];
        db[len - 2] = cost[len - 2];

        while (i >= 0) {
            int current = cost[i];
            db[i] = Math.min(current + db[i + 1], current + db[i + 2]);
            i--;
        }

        if (db[0] < db[1]) {
            return db[0];
        }

        return db[1];
    }

    // best solution here: https://leetcode.com/problems/min-cost-climbing-stairs/solutions/476388/4-ways-step-by-step-from-recursion-top-down-dp-bottom-up-dp-fine-tuning/
}
