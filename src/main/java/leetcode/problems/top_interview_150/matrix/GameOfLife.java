package leetcode.problems.top_interview_150.matrix;

import java.util.ArrayList;
import java.util.List;

public class GameOfLife {

    public static void main(String[] args) {
        int[][] matrix = {
                {0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0}
        };
        gameOfLife(matrix);
    }
    // I have seen a bit manipulation solution but I cannot reproduce it in my head
    // TODO https://leetcode.com/problems/game-of-life/solutions/73230/c-o-1-space-o-mn-time/
    public static void gameOfLife(int[][] board) {
        int rowsN = board.length;
        int colsN = board[0].length;

        for (int i = 0; i < rowsN; i++) {
            for (int j = 0; j < colsN; j++) {
                board[i][j] = willSurvive(board, i, j);
            }
        }

        for (int i=0; i<rowsN; ++i) {
            for (int j=0; j<colsN; ++j){
                int val = board[i][j];
                if (val == -1) {
                    board[i][j] = 0;
                } else if(val == 2) {
                    board[i][j] = 1;
                }
            }
        }
    }

    public static int willSurvive(int[][] matrix, int i, int j) {
        int counter = 0;

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Define the relative coordinates for all neighbors
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int k = 0; k < 8; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            // Check if the neighbor is within the matrix bounds
            if (x >= 0 && x < rows && y >= 0 && y < cols && (matrix[x][y] ==1 || matrix[x][y] == -1)) {
                counter++;
            }
        }
        int val = matrix[i][j];
        if (val == 1 && counter < 2) {
            return -1;
        }
        if (val == 1 && (counter == 2 || counter ==3)) {
            return 1;
        }
        if (val == 1 &&  counter >3) {
            return -1;
        }
        if (val == 0 &&  counter  ==3) {
            return 2;
        }
        return 0;
    }
}
