package leetcode.problems.top_interview_150.matrix;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SpiralMatrix {

    public static void main(String[] args) {
/*
        int[][] twoDimensionalArray = {
                {23,18,20,26,25},
                {24,22,3,4,4},
                {15,22,2,24,29},
                {18,15,23,28,28}
        };
 */
        int[][] twoDimensionalArray = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

/*
        int[][] twoDimensionalArray = {
                {1}
        };
         */
        System.out.println(spiralOrder(twoDimensionalArray));
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList();
        int nRows = matrix.length;
        int nCols = matrix[0].length;
        int n = nRows * nCols;
        Set<String> visited = new HashSet();

        int direction = 1;
        int rIdx = 0;
        int cIdx = 0;

        while (visited.size() != n) {
            System.out.println(res);
            int el = matrix[rIdx][cIdx];
            res.add(el);
            visited.add("" + rIdx + cIdx);

            if (direction ==1){
                int next = cIdx + 1;
                if (cIdx == nCols-1 || visited.contains("" + rIdx + next)) {
                    direction=2;
                    rIdx++;
                } else {
                    cIdx++;
                }
            } else if (direction == 2){
                int next = rIdx + 1;
                if (rIdx == nRows-1 || visited.contains(""  + next + cIdx)) {
                    direction=3;
                    cIdx--;
                } else {
                    rIdx++;
                }
            } else if (direction ==3){
                int next = cIdx - 1;
                if (cIdx == 0 || visited.contains("" + rIdx + next)) {
                    direction=4;
                    rIdx--;
                } else {
                    cIdx--;
                }
            } else if (direction ==4){
                int next = rIdx - 1;
                if (rIdx == 0 || visited.contains(""  + next + cIdx) ) {
                    direction=1;
                    cIdx++;
                } else {
                    rIdx--;
                }
            }


        }
        return res;
    }
}
