package leetcode.problems.arrays;

public class MinimumTimeVisitingAllPoints {

    public int minTimeToVisitAllPoints(int[][] points) {
        int sum = 0;
        for (int i = 1; i < points.length; i++) {
           sum += dist(points[i], points[i-1]);
        }

        return sum;
    }

    private int dist(int[] to, int[] from) {
        int distX = Math.abs(to[0] - from[0]);
        int distY = Math.abs(to[1] - from[1]);
        return Math.max(distX, distY);
    }
}
