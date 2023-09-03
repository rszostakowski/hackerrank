package leetcode.problems.backtracking;
import java.util.*;

public class WordSearch {
    public static void main3(String[] args) {
        WordSearch ws = new WordSearch();
        String word = "ABCB";
        char[][] board = new char[][]{
                new char[]{'A', 'B', 'C', 'E'},
                new char[]{'S', 'F', 'C', 'S'},
                new char[]{'A', 'D', 'E', 'E'}
        };
        ws.exist(board, word);
    }

    public static void main(String[] args) {
        WordSearch ws = new WordSearch();
        String word = "ABCD";
        char[][] board = new char[][]{
                new char[]{'A', 'B'},
                new char[]{'C', 'D'}
        };
        ws.exist(board, word);
    }

    public boolean exist(char[][] board, String word) {
        int rowsN = board.length;
        int colsN = board[0].length;

        for (int i = 0; i < rowsN; i++) {
            for (int j = 0; j < colsN; j++) {
                if(backtrack(board, word, i, j, 0, rowsN, colsN)){
                    return true;
                }
            }
        }
        return false;
    }

    boolean backtrack(char[][] board, String word, int row, int col, int idx, int rowsN, int colsN) {
        if (row<rowsN && row >= 0 && col >= 0  &&  col< colsN ) {
            char let = board[row][col];

            if (let == word.charAt(idx)) {
                board[row][col] = '#'; // Mark the cell as visited
                idx++;
                if (idx == word.length()) {
                    return true;
                }
                // Define the relative coordinates for all neighbors
                int[] dx = {-1, 1, 0, 0};
                int[] dy = {0, 0,-1, 1};

                for (int k = 0; k < 4; k++) {
                    int x = row + dx[k];
                    int y = col + dy[k];

                    if (backtrack(board, word, x, y, idx, rowsN, colsN)){
                        return true;
                    }
                }
                board[row][col] = let;
            }
        }
        return false;
    }
}
