package leetcode.problems.stacks;

import java.util.Stack;

public class DailyTemperatures {

    public static void main(String[] args) {
        int[] nums = {73,74,75,71,69,72,76,73};
        System.out.println(dailyTemperaturesBest(nums));
    }

    // my solution
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];

        int prev = 0;
        for (int i = 0; i<n; i++) {
            int val = temperatures[i];
            if (val == prev && res[i-1] > 0) {
                res[i] = res[i-1] -1;
            } else {
                for (int k = i+1; k<n; k++) {
                    if (temperatures[k] > val)  {
                        res[i] = k - i;
                        break;
                    }
                }
            }
            prev = val;
        }

        return res;
    }

    // best solution from the comments section
    public static int[] dailyTemperaturesBest(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int currDay = 0; currDay < temperatures.length; currDay++) {
            while (!stack.isEmpty() && temperatures[currDay] > temperatures[stack.peek()]) {
                int prevDay = stack.pop();
                ans[prevDay] = currDay - prevDay;
            }
            stack.add(currDay);
        }
        return ans;
    }
}
