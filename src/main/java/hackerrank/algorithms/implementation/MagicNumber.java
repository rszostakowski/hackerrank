package hackerrank.algorithms.implementation;

import java.util.Scanner;

public class MagicNumber {

    static int[][] sol1 =  {
            {2, 9, 4},
            {7, 5, 3},
            {6, 1, 8}
    };

    static int[][] sol2 =  {
            {4, 9, 2},
            {3, 5, 7},
            {8, 1, 6}
    };

    static int[][] sol3 =  {
            {2, 7, 6},
            {9, 5, 1},
            {4, 3, 8}
    };

    static int[][] sol4 =  {
            {4, 3, 8},
            {9, 5, 1},
            {2, 7, 6}
    };

    static int[][] sol5 =  {
            {6, 1, 8},
            {7, 5, 3},
            {2, 9, 4}
    };

    static int[][] sol6 =  {
            {8, 1, 6},
            {3, 5, 7},
            {4, 9, 2}
    };

    static int[][] sol7 =  {
            {6, 7, 2},
            {1, 5, 9},
            {8, 3, 4}
    };

    static int[][] sol8 =  {
            {8, 3, 4},
            {1, 5, 9},
            {6, 7, 2}
    };


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] s = new int[3][3];
        for(int s_i=0; s_i < 3; s_i++){
            for(int s_j=0; s_j < 3; s_j++){
                s[s_i][s_j] = in.nextInt();
            }
        }
        ResultMagicNumber result = new ResultMagicNumber();
        calculateDifference(result, s, sol1);
        calculateDifference(result, s, sol2);
        calculateDifference(result, s, sol3);
        calculateDifference(result, s, sol4);
        calculateDifference(result, s, sol5);
        calculateDifference(result, s, sol6);
        calculateDifference(result, s, sol7);
        calculateDifference(result, s, sol8);

        System.out.println(result.minimumDiff);
    }

    private static void calculateDifference(ResultMagicNumber result, int[][] inputMatrix, int[][] solutionMatrix) {
        int minDiff = 0 ;

        for(int i=0; i < 3; i++){
            for(int j=0; j < 3; j++){
                minDiff += Math.abs(inputMatrix[i][j]-solutionMatrix[i][j]);
            }
        }

        if(minDiff < result.minimumDiff) {
            result.minimumDiff = minDiff;
        }
    }
}

class ResultMagicNumber {
    int minimumDiff = Integer.MAX_VALUE;
}