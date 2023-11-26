package leetcode.problems.arrays;

import java.util.Arrays;

public class MaximumNumberOfCoinsYouCanGet {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);

        int left = 0;
        int right = piles.length-1;
        int counter = 0;
        while (left < right) {
            left++;
            right--;
            counter+=piles[right];
            right--;
        }

        return counter;
    }
}
