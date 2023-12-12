package leetcode.problems.backtracking;

import java.util.*;

//https://leetcode.com/problems/path-with-minimum-effort/solutions/
public class PathWithMinimumEffort
{

    public static void main(String[] args) {
        PathWithMinimumEffort path = new PathWithMinimumEffort();
        int[][] heights;
//        heights = new int[][] {
//                {1,2,3},
//                {3,8,4},
//                {5,3,5}
//        };
//        heights = new int[][] {
//                {1,2,2},
//                {3,8,2},
//                {5,3,5}
//        };
        heights = new int[][] {
                {8,6,8,1,4,1},
                {10,3,1,8,9,10},
                {1,5,6,9,8,5},
                {10,4,6,7,3,3},
                {6,6,9,1,3,3},
                {3,1,10,3,4,1},
                {6,1,6,10,7,10}
        };

        System.out.println(path.minimumEffortPath_notFastEnough(heights));
    }


    public int minimumEffortPath_notFastEnough(int[][] heights) {
        List<Integer> paths = new LinkedList();
        Set<Set<Point>> visited = new HashSet<>();
        backtracting(paths, visited, heights, Integer.MIN_VALUE, 0, 0, new HashSet<>(),  heights.length, heights[0].length);
        return paths.stream().mapToInt(Integer::intValue).min().getAsInt();
    }

    private void backtracting(List<Integer> paths, Set<Set<Point>> visited, int[][] heights, int cost, int row, int col, Set<Point> path, int rowsN, int colsN) {
        if (row<rowsN && row >= 0 && col >= 0  &&  col< colsN ) {
            int localCost = heights[row][col];
            path.add(new Point(row, col));
            if (!visited.contains(path)) {
                Set<Set<Point>> newPartial = new HashSet(path);
                newPartial.add(path);
                if (row == rowsN - 1 && col == colsN - 1) {
                    paths.add(cost);
                }
                heights[row][col] = -1; // Mark the cell as visited

                int[] dx = {1, 0, -1};
                int[] dy = {0, 1, 0};

                for (int k = 0; k < 3; k++) {
                    int x = row + dx[k];
                    int y = col + dy[k];

                    if (x < rowsN && x >= 0 && y < colsN && heights[x][y] != -1 && !newPartial.contains(new Point(x,y))) {
                        int diff = Math.abs(localCost - heights[x][y]);
                        backtracting(paths, newPartial, heights, Math.max(cost, diff), x, y, path, rowsN, colsN);
                    }
                }
                System.out.println(path);
                heights[row][col] = localCost;
            }
        }
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }




    // works but with help of chatgpt
    public int minimumEffortPath(int[][] heights) {
        int rowsN = heights.length;
        int colsN = heights[0].length;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[]{0, 0, 0}); // {effort, row, col}

        int[][] efforts = new int[rowsN][colsN];
        for (int[] row : efforts) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!minHeap.isEmpty()) {
            int[] polled = minHeap.poll();
            int effort = polled[0];

            int row =polled[1];
            int col =polled[2];

            System.out.println("effort: " + effort + " row: " + row + " col: " + col + " heights[row][col]: " + heights[row][col]);
            if (row == rowsN-1 && col == colsN-1) {
                return effort;
            }

            for (int i = 0; i < 4; i++) {
                int newRow = row + dx[i];
                int newCol = col + dy[i];

                if (newRow >= 0 && newRow < rowsN && newCol >= 0 && newCol < colsN) {
                    if (row == 5 && col == 5) {
                        System.out.println("here");
                    }
                    int newEffort = Math.max(effort, Math.abs(heights[newRow][newCol] - heights[row][col]));
                    if (newEffort < efforts[newRow][newCol]) {
                        efforts[newRow][newCol] = newEffort;
                        minHeap.offer(new int[]{newEffort, newRow, newCol});
                    }
                }
            }
        }
        return -1;
    }

}
