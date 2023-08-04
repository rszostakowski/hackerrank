package leetcode.problems.top_interview_150.arrays;

import java.util.Arrays;

public class GasStation {

    public static void main(String[] args) {
        int[] gas = new int[] {1,2,3,4,5};
        int[] cost = new int[] {3,4,5,1,2};
        canCompleteCircuit2(gas, cost);

    }
    // my solution O(n) but still they have better one
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = cost.length;

        int[] diff = new int[n];
        int minDiff = Integer.MAX_VALUE;
        int[] sumOfDiffs = new int[n];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = gas[i] - cost[i];
            if (i > 0) {
                sumOfDiffs[i] = diff[i] + sumOfDiffs[i-1];
                if (minDiff >= sumOfDiffs[i]) {
                    minDiff = sumOfDiffs[i];
                    idx = i;
                }
            } else {
                sumOfDiffs[0] = diff[0];
                minDiff = sumOfDiffs[0];
                idx = 0;
            }
        }

        int fuel = 0;
        idx = (idx+1) % n;
        for (int i = idx; i < n + idx; i++) {
            int change = diff[i%n];
            fuel += change;
        }

        if (fuel >= 0) {
            return idx;
        }

        return -1;
    }

    // best solution form the solutions section
    public static int canCompleteCircuit2(int[] gas, int[] cost) {
        int n = gas.length;
        int total_surplus = 0;
        int surplus = 0;
        int start = 0;

        for(int i = 0; i < n; i++){
            total_surplus += gas[i] - cost[i];
            surplus += gas[i] - cost[i];
            if(surplus < 0){
                surplus = 0;
                start = i + 1;
            }
        }
        return (total_surplus < 0) ? -1 : start;
    }
}
