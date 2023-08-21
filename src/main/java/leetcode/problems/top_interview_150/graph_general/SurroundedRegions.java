package leetcode.problems.top_interview_150.graph_general;

import java.util.Arrays;

public class SurroundedRegions {
    public static void main(String[] args) {
        char[][] grid = {
                {'X', 'X','X','X'},
                {'X', 'O','O','X'},
                {'X', 'X','O','X'},
                {'X', 'O','X','X'},

        };
        solve(grid);
    }

    public static void solve(char[][] board) {
        int rN = board.length;
        int cN = board[0].length;
        char[][] newGrid = new char[rN][cN];
        for (int i = 0; i < rN; i++) {
            for (int j = 0; j < cN; j++) {
                newGrid[i][j] = board[i][j];
                board[i][j] = 'X';
            }
        }

        for (int j = 0; j < cN; j++) {
            if (newGrid[0][j]=='O') {
                doNotEliminate(board, newGrid, 0, j, rN, cN);
            }
        }
        for (int j = 0; j < cN; j++) {
            if (newGrid[rN-1][j]=='O') {
                doNotEliminate(board, newGrid, rN-1, j, rN, cN);
            }
        }

        for (int j = 0; j < rN; j++) {
            if (newGrid[j][0]=='O') {
                doNotEliminate(board, newGrid, j, 0, rN, cN);
            }
        }

        for (int j = 0; j < rN; j++) {
            if (newGrid[j][cN-1]=='O') {
                doNotEliminate(board, newGrid, j, cN-1, rN, cN);
            }
        }

        for (int i = 0; i <newGrid.length; i++) {
            System.out.println(Arrays.toString(newGrid[i]));
        }
        for (int i = 0; i <board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }

    }

    private static void doNotEliminate(char[][] grid, char[][] newGrid, int i, int j, int rN, int cN) {
        if (i < 0 || j < 0 || i >= rN || j >= cN)
            return;
        if (newGrid[i][j] == 'O') {
            grid[i][j] = 'O';
            newGrid[i][j] = 'X';
            doNotEliminate(grid, newGrid, i-1, j, rN, cN);
            doNotEliminate(grid, newGrid, i+1, j, rN, cN);
            doNotEliminate(grid, newGrid, i, j-1, rN, cN);
            doNotEliminate(grid, newGrid, i, j+1, rN, cN);
        }
    }
}
