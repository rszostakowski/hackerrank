package leetcode.problems.arrays;

public class MinimumPenaltyForShop {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        char[] chars = customers.toCharArray();
        int[] penalities = new int[n+1];

        int[] absent = new int[n+1];
        int[] open = new int[n+1];

        int absentCount = 0;
        for (int i = 1; i < n + 1; i++) {
            absentCount += (chars[i - 1] == 'N') ? 1 : 0;
            absent[i] = absentCount;
        }

        int openCount = 0;
        for (int i = n - 1; i >= 0; i--) {
            openCount += (chars[i] == 'N') ? 0 : 1;
            open[i] = openCount;
        }

        for (int i = n; i>= 0; i--) {
            penalities[i] = absent[i] + open[i];
        }

        int min = Integer.MAX_VALUE;
        int idx = 0;
        for (int i = 0; i < n+1; i++) {
            if (min > penalities[i]) {
                min = penalities[i];
                idx = i;
            }
        }

        return idx;
    }

    // best solution from the comments section
    // https://leetcode.com/problems/minimum-penalty-for-a-shop/solutions/2858372/java-o-n-solution/
    public int bestClosingTimeBest(String customers) {
        int maxProfit = 0;
        int profit = 0;
        int hour = 0;

        for(int i=0; i<customers.length(); i++){
            profit = customers.charAt(i)=='Y' ? profit+1 : profit-1;
            if(profit>maxProfit){
                maxProfit = profit;
                hour = i+1;
            }
        }

        return hour;
    }
}
