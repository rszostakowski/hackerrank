package hackerrank.algorithms.javaLanguage;

import java.util.Arrays;
import java.util.Scanner;

public class Java1DArray {

    public static boolean canWin(int leap, int[] game) {
        if( leap > game.length) {
            return false;
        }
        Result result = new Result();

        Arrays.stream(game)
                .forEach(el -> {
                            if (el == 1) {
                                result.counter++;
                            } else {
                                if (result.counter > result.maxOneInRow) {
                                    result.maxOneInRow = result.counter;
                                }
                                result.counter = 0;
                            }
                        }
                );

        if (leap > result.maxOneInRow){
            int current = game.length;
            for (int i = current - leap; i<= game.length; i++) {
                if (game[i] == 0) {
                    current = i;
                    break;
                }
            }
            while(current > 0) {
                if(current-leap == -1) {
                    return true;
                }
                if(current-leap >= 0 && game[current-leap] == 0) {
                    current = current-leap;
                } else if (game[current-1] == 0) {
                    current = current-1;
                } else {
                    return false;
                }
            }
            return current == 0;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println((canWin(leap, game)) ? "YES" : "NO");
        }
        scan.close();
    }
}

class Result {
    int counter = 0;
    int maxOneInRow = Integer.MIN_VALUE;
}