package leetcode.problems.graphs;

import leetcode.problems.backtracking.WordSearch;

public class WallsAndGates {


    // https://www.lintcode.com/problem/663/
    public static void main(String[] args) {
        WallsAndGates wag = new WallsAndGates();
        int[][] rooms = new int[][] {
                {2147483647,-1,0,2147483647},
                {2147483647,2147483647,2147483647,-1},
                {2147483647,-1,2147483647,-1},
                {0,-1,2147483647,2147483647}
        };

        wag.wallsAndGates(rooms);
        System.out.println(rooms);
    }
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0) return;
        int numOfRows = rooms.length;
        int numOfCols = rooms[0].length;

        for(int i=0; i<numOfRows; i++) {
            for(int j=0; j<numOfCols; j++) {
                if(rooms[i][j] == 0) rotAdjacent(rooms, i, j, 0, numOfRows, numOfCols);
            }
        }
    }

    private void rotAdjacent(int[][] grid, int i, int j, int moves, int numOfRows, int numOfCols) {
        if(i < 0 || i >= grid.length /* out of bounds */
                || j < 0 || j >= grid[0].length /* out of bounds */
                || grid[i][j] == -1 /*it is a wall */
                || (0 <= grid[i][j] && grid[i][j] < moves) /* there is a shorter path already used */
        ) return;
        else {
            grid[i][j] = moves;
            System.out.println("Changing i: " + i + " j: " + j + " to: " + moves);
            rotAdjacent(grid, i - 1, j, moves + 1, numOfRows, numOfCols);
            rotAdjacent(grid, i + 1, j, moves + 1, numOfRows, numOfCols);;
            rotAdjacent(grid, i, j - 1, moves + 1, numOfRows, numOfCols);
            rotAdjacent(grid, i, j + 1, moves + 1, numOfRows, numOfCols);
        }
    }



    private static void printBoard(int[][] board) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            int[] numbers = board[i];
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < numbers.length; j++) {
                sb.append(numbers[j]);
                if (j < numbers.length - 1) {
                    sb.append(",");
                }
            }

            String result = sb.toString();
            System.out.println(result);
        }
        System.out.println();
    }
}