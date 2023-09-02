package leetcode.problems.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    // the most optimazited solution which I found
    PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1, o2) -> euclidian(o2) -  euclidian(o1));

    public int[][] kClosest(int[][] points, int k) {
        for (int[] point: points) {
            pq.add(point);
            if (pq.size() > k) {
                pq.remove();
            }
        }

        int idx = 0;
        int[][] res = new int[k][2];
        while(pq.size()>0 && idx < k) {
            int[] point = pq.poll();
            res[idx] = point;
            idx++;
        }

        return res;
    }

    public int euclidian(int[] point) {
        return point[0]*point[0] + point[1] * point[1];
    }

    // crazy solutiopn from the comment section
    public int[][] kClosestBest(int[][] points, int K) {
        Arrays.sort(points, (p1, p2) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);
        return Arrays.copyOfRange(points, 0, K);
    }
}
