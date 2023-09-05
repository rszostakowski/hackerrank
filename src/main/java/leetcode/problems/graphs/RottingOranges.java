package leetcode.problems.graphs;

public class RottingOranges {

    // works as charm!
    // the best solution from the internet https://leetcode.com/problems/rotting-oranges/solutions/602284/java-dfs-beats-100/

    public int orangesRotting(int[][] grid) {
        int numRows = grid.length;
        int numCols = grid[0].length;

        boolean somethingHasRottened = true;
        int count = 0;
        while(somethingHasRottened) {

            somethingHasRottened = false;
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < numCols; j++) {
                    if (grid[i][j] == 1) {
                        if (hasRottenedNeighbour(grid, i, j, numRows, numCols)){
                            somethingHasRottened = true;
                            grid[i][j] = 3;
                        }
                    }
                }
            }


            if (somethingHasRottened){
                count++;
                // convert 3 to 2
                for (int i = 0; i < numRows; i++) {
                    for (int j = 0; j < numCols; j++) {
                        if (grid[i][j] == 3) {
                            grid[i][j] = 2;
                        }
                    }
                }
            }
        }

        // check if some 1 left
        boolean onlyZeros = true;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (grid[i][j] == 2 || grid[i][j] == 1) {
                    onlyZeros = false;
                    if (grid[i][j] == 1) {
                        return -1;
                    }
                }
            }
        }
        return onlyZeros ? 0: count;
    }

    private boolean hasRottenedNeighbour(int[][] grid, int row, int col, int numOfRows, int numOfCols) {

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int k = 0; k < dx.length; k++) {
            int x = row + dx[k];
            int y = col + dy[k];
            if (x<numOfRows && x >= 0 && y >= 0  &&  y <numOfCols && grid[x][y] == 2) {
                return true;
            }
        }
        return false;
    }


    // the best solution from the comments section
    // https://leetcode.com/problems/rotting-oranges/solutions/602284/java-dfs-beats-100/
    public int orangesRottingBest(int[][] grid) {
        if(grid == null || grid.length == 0) return -1;

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 2) rotAdjacent(grid, i, j, 2);
            }
        }

        int minutes = 2;
        for(int[] row : grid) {
            for(int cell : row) {
                if(cell == 1) return -1;
                minutes = Math.max(minutes, cell);
            }
        }

        return minutes - 2;
    }

    private void rotAdjacent(int[][] grid, int i, int j, int minutes) {
        if(i < 0 || i >= grid.length /* out of bounds */
                || j < 0 || j >= grid[0].length /* out of bounds */
                || grid[i][j] == 0 /* empty cell */
                || (1 < grid[i][j] && grid[i][j] < minutes) /* this orange is already rotten by another rotten orange */
        ) return;
        else {
            grid[i][j] = minutes;
            rotAdjacent(grid, i - 1, j, minutes + 1);
            rotAdjacent(grid, i + 1, j, minutes + 1);
            rotAdjacent(grid, i, j - 1, minutes + 1);
            rotAdjacent(grid, i, j + 1, minutes + 1);
        }
    }
}
