package leetcode.problems.arrays;

public class RemoveColoredPieces {
    public boolean winnerOfGame(String colors) {
        int counterA = 0;
        int counterB = 0;

        char[] chars = colors.toCharArray();

        for (int i = 1; i < chars.length-1; i++) {
            char prev = chars[i-1];
            char cur = chars[i];
            char next = chars[i+1];
            if (prev == cur && cur == next && cur == 'A') {
                counterA++;
            }

            if (prev == cur && cur == next && cur == 'B') {
                counterB++;
            }
        }
        //System.out.println("counterA: "+ counterA + " counterB: " + counterB);
        if (counterA > counterB)
            return true;
        return false;
    }
}
