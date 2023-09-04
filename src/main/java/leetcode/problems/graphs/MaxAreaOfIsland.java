package leetcode.problems.graphs;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int max = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(dfs(grid, i, j, m, n), max);
                }
            }
        }

        return max;
    }

    public int dfs(int[][] grid, int row, int col, int numOfRows, int numOfCols) {
        if (row<numOfRows && row >= 0 && col >= 0  &&  col<numOfCols ) {
            int let = grid[row][col];

            if (let == 1) {
                grid[row][col] = 0;
                int[] dx = {1, -1, 0, 0};
                int[] dy = {0, 0, 1, -1 };

                int sum = 1;
                for (int k = 0; k < dx.length; k++) {
                    int x = row + dx[k];
                    int y = col + dy[k];
                    sum += dfs(grid, x, y, numOfRows, numOfCols);
                }
                return sum;
            }
        }

        return 0;
    }
}
