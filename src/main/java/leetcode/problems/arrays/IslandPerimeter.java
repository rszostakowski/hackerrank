package leetcode.problems.arrays;

public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) {
        int tiles = 0;
        int connections = 0;

        int rowsN = grid.length;
        int colsN = grid[0].length;
        int[] dx = {1, 0};
        int[] dy = {0, 1};

        for (int row = 0; row <rowsN; row++) {
            for (int col = 0; col <colsN; col++) {
                if (grid[row][col] == 1) {
                    tiles++;
                    for (int i = 0; i < 2; i++) {
                        int newRow = row + dx[i];
                        int newCol = col + dy[i];

                        if (newRow >= 0 && newRow < rowsN && newCol >= 0 && newCol < colsN && grid[newRow][newCol] == 1) {
                            connections++;
                        }
                    }
                }
            }
        }
        //System.out.println("tiles: " +  tiles + " connections: " + connections);

        return tiles * 4 - connections * 2;
    }
}
