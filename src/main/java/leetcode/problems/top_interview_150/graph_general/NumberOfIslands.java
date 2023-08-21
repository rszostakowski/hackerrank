package leetcode.problems.top_interview_150.graph_general;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1','1'},
                {'0', '1','0'},
                {'1', '1','1'}
        };
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int rN = grid.length;
        int cN = grid[0].length;

        int count = 0;
        for (int i = 0; i < rN; i++) {
            for (int j = 0; j < cN; j++) {
                if (grid[i][j]=='1') {
                    eliminateOtherTiles(grid, i, j, rN, cN);
                    count++;
                }

            }
        }
        return count;
    }

    private static void eliminateOtherTiles(char[][] grid, int i, int j, int rN, int cN) {
        if (i < 0 || j < 0 || i >= rN || j >= cN)
            return;
        if (grid[i][j] == '1') {
            grid[i][j] = 0;
            eliminateOtherTiles(grid, i-1, j, rN, cN);
            eliminateOtherTiles(grid, i+1, j, rN, cN);
            eliminateOtherTiles(grid, i, j-1, rN, cN);
            eliminateOtherTiles(grid, i, j+1, rN, cN);
        }
    }

}
