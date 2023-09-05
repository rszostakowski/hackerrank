package leetcode.problems.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PacificAtlanticWaterFlow {

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1,2,2,3,5},
                {3,2,3,4,4},
                {2,4,5,3,1},
                {6,7,1,4,5},
                {5,1,1,2,4}
        };

        PacificAtlanticWaterFlow flow = new PacificAtlanticWaterFlow();

        flow.pacificAtlantic(nums);

    }

    public static void main2(String[] args) {
        int[][] nums = new int[][]{
                {1,2,3},
                {8,9,4},
                {7,6,5}};

        PacificAtlanticWaterFlow flow = new PacificAtlanticWaterFlow();

        flow.pacificAtlantic(nums);

    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        List<List<Integer>> res = new LinkedList();
        boolean[][] visited = new boolean[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                boolean first = pacific(heights,new boolean[m][n], i, j, m, n);
                boolean second = atlantic(heights,new boolean[m][n], i, j, m, n);
                //System.out.println("i: " + i + " j: " + j + " pacific: " +first + " atlantic: " + second);
                if (first && second) {
                    List node = Arrays.asList(i, j);
                    res.add(node);
                }
            }
        }

        return res;
    }

    public boolean pacific(int[][] heights, boolean[][] visited, int row, int col, int numOfRows, int numOfCols) {
        if (row == 0 ||  col == 0) {
            return true;
        }

        if (row<numOfRows && row >= 0 && col >= 0  &&  col<numOfCols && !visited[row][col]) {
            int[] dx = {1, 0, -1, 0};
            int[] dy = {0, 1, 0, -1};
            visited[row][col] = true;
            for (int k = 0; k < dx.length; k++) {
                int x = row + dx[k];
                int y = col + dy[k];

                if (x<numOfRows && x >= 0 && y >= 0  &&  y <numOfCols && heights[x][y] <= heights[row][col]) {

                    if(pacific(heights,visited, x, y, numOfRows, numOfCols)) {
                        return true;
                    }

                }
            }
            visited[row][col] = false;
        }

        return false;
    }


    public boolean atlantic(int[][] heights, boolean[][] visited, int row, int col, int numOfRows, int numOfCols) {
        if (row == numOfRows-1 ||  col == numOfCols-1) {
            return true;
        }

        if (row<numOfRows && row >= 0 && col >= 0  &&  col<numOfCols && !visited[row][col]) {
            int[] dx = {1, 0, -1, 0};
            int[] dy = {0, 1, 0, -1};
            visited[row][col] = true;
            for (int k = 0; k < dx.length; k++) {
                int x = row + dx[k];
                int y = col + dy[k];

                if (x<numOfRows && x >= 0 && y >= 0  &&  y <numOfCols && heights[x][y] <= heights[row][col]) {

                    if(atlantic(heights, visited, x, y, numOfRows, numOfCols)) {
                        return true;
                    }
                }
            }

            visited[row][col] = false;
        }

        return false;
    }
}
