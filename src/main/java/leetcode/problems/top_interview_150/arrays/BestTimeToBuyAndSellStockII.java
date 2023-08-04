package leetcode.problems.top_interview_150.arrays;

public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int lsf = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price: prices) {
            lsf = Math.min(price, lsf);

            int profsf = price - lsf;

            if (profsf > 0) {
                lsf = price;
            }
            maxProfit += Math.max(profsf, 0);
        }

        return maxProfit;
    }

    // the best solution which I found
/*    int maxProfit(vector<int> &prices) {
        int ret = 0;
        for (size_t p = 1; p < prices.size(); ++p)
            ret += max(prices[p] - prices[p - 1], 0);
        return ret;
    }*/
}
