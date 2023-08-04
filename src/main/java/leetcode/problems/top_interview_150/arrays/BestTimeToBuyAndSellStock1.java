package leetcode.problems.top_interview_150.arrays;

public class BestTimeToBuyAndSellStock1
{
    public int maxProfit(int[] prices) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int dist = 0;
        for (int i = 0; i < prices.length; i++) {
            int cur = prices[i];
            if (min != Integer.MAX_VALUE && cur > max) {
                max = cur;
                dist = Math.max(dist, max - min);
            }

            if (cur < min) {
                min = cur;
                max = Integer.MIN_VALUE;
            }
        }

        return dist;
    }
}
