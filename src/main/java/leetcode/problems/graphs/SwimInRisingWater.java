package leetcode.problems.graphs;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SwimInRisingWater {
    public static void main(String[] args) {
        SwimInRisingWater swimInRisingWater = new SwimInRisingWater();
        int[][] grid = new int[][]{
                {0,2},
                {1,3}
        };
        swimInRisingWater.swimInWater(grid);
    }
    public int swimInWater(int[][] grid) {
        int rowsN = grid.length;
        int colsN = grid[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        if (rowsN > 1) {
            pq.offer(new int[]{1, 0, grid[1][0]});
        }

        if (colsN > 1) {
            pq.offer(new int[]{0, 1, grid[0][1]});
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int max = grid[0][0];
        Set<SPoint> visited = new HashSet();
        visited.add(new SPoint(0,0));

        while (!pq.isEmpty()) {
            int[] point = pq.poll();
            System.out.println("Visitng point: " + point[0] + " " + point[1] );
            max = Math.max(max, point[2]);
            visited.add(new SPoint(point[0], point[1]));

            if (point[0] == rowsN-1 && point[1] == colsN-1) {
                return max;
            }
            for (int i = 0; i < 4; i++) {
                int newRow = point[0] + dx[i];
                int newCol = point[1] + dy[i];

                if (!visited.contains(new SPoint(newRow, newCol)) && newRow >= 0 && newRow < rowsN && newCol >= 0 && newCol < colsN) {
                    pq.offer(new int[]{newRow, newCol, grid[newRow][newCol]});
                }
            }
        }
        return 0;
    }

    class SPoint {
        int x;
        int y;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            SPoint sPoint = (SPoint) o;

            if (x != sPoint.x) return false;
            return y == sPoint.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }

        public SPoint(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
