package leetcode.problems.binary_search;

public class GuessNumberHigherOrLower {
    public int guessNumber(int n) {

        long left = 0;
        long right = n;
        long pick = (left + right)/2;

        while (guess((int) pick) !=0){
            //System.out.println("n: " + n + " pick: "+ pick);
            int g = guess((int) pick);
            if (g == 1){
                left = pick+1;
            } else {
                right = pick-1;
            }

            pick = (left + right)/2;
        }
        return (int) pick;
    }

    private int guess(int pick) {
        return 0;
    }
}
