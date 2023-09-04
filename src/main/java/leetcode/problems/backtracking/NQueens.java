package leetcode.problems.backtracking;


import java.util.LinkedList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {

        solveNQueens(2);
    }
    public static List<List<String>> solveNQueens(int n) {

        List<List<String>> results = new LinkedList();
        char[][] board = new char[n][n];

        // Initialize the board with '.'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("Starting from i: " + i + " j:  " + j);
                board[i][j] = '.';
            }
        }
        board[0][0] = 'Q';
        backtrack(board, results, 1, 0, 0, n);
  /*      for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'Q';
                backtrack(board, results, 1, i, j, n);
                board[i][j] = '.';
            }
        }*/
        return results;
    }

    static void backtrack(char[][] board, List<List<String>> results, int tracker,  int row, int col, int n) {
        printBoarD(board);
        if (tracker == n) {
            System.out.println("MATCH");
            return;
        }

        if (row<n && row >= 0 && col >= 0  &&  col< n ) {
            char let = board[row][col];

            if (board[row][row] == '#')
                return ;

            boolean canBePlaced = !checkIfQInRowOrCol(board, row, col);

            if (canBePlaced) {
                tracker++;
                board[row][col] = 'Q'; // Mark the cell as visited
            } else if (board[row][col] != 'Q'){
                board[row][col] = '#';
            }
            // Define the relative coordinates for all neighbors
            int[] dx = {0, 1};
            int[] dy = {1, 0};

            for (int k = 0; k < 2; k++) {
                int x = row + dx[k];
                int y = col + dy[k];

                backtrack(board, results, tracker, x, y, n);
            }
            //board[row][col] = '.';
            if (canBePlaced) {
                board[row][col] = let;
            }
        }
    }

    private static void printBoarD(char[][] board) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            System.out.println(new String(board[i]));
        }
        System.out.println();
    }

    private static boolean checkIfQInRowOrCol(char[][] board, int rowIdx, int colIdx) {

        char[] rowElements = board[rowIdx];
        for (char element : rowElements) {
            if (element == 'Q')
                return true;
        }

        for (int i = 0; i < board.length; i++) {
            int element = board[i][colIdx];
            if (element == 'Q')
                return true;
        }

        return false;
    }
}
