package leetcode.problems.binary_search;

import java.util.Arrays;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);

        int n = piles.length;

        int attemptsPerSlot = h / n;

        System.out.println("attemptsPerSlot: " + attemptsPerSlot + " left: " + h % n);

        int sum = 0;
        for (int i = 0 ; i < n; i++) {
            sum += piles[i];
        }


        int idxToFind = n - h%n -1;

        System.out.println("to find: " + idxToFind + " val: " + piles[idxToFind]);

        int startingVal = piles[idxToFind] / attemptsPerSlot;

        int minimal = startingVal;
        for (int i = startingVal -1; i >= 1; i--) {
            boolean allHigher = true;
            for (int j = 0 ; j < n; j++) {
                if (piles[j] >= i  * attemptsPerSlot) {
                    int saved =  1; // TODO
                    //if(canWeUsedSaved(piles[j], saved)) {

                    //} else {
                        allHigher = false;
                        break;
                    //}
                }
            }
            if (allHigher)
                minimal = i;
        }

        return minimal;
    }

    public boolean canWeUsedSaved(int pile, int saved, int perHour, int attempts) {
        return false;
    }
}
