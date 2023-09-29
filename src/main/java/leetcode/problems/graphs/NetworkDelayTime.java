package leetcode.problems.graphs;

import java.util.*;

public class NetworkDelayTime {
    public static void main(String[] args) {
/*        int[][] times = new int[][]{
                {2, 1, 1}, {2, 3, 1}, {3, 4, 1}
        };*/
        //networkDelayTime(times, 4, 2);

/*        int[][] times = new int[][]{
                {1,2,1}, {2,3,2}, {1,3,2}
        };
        networkDelayTime(times, 3, 1);*/

        int[][] times = new int[][]{
                {2,4,10},
                {5,2,38},
                {3,4,33},
                {4,2,76},
                {3,2,64},
                {1,5,54},
                {1,4,98},
                {2,3,61},
                {2,1,0},
                {3,5,77},
                {5,1,34},
                {3,1,79},
                {5,3,2},
                {1,2,59},
                {4,3,46},
                {5,4,44},
                {2,5,89},
                {4,5,21},
                {1,3,86},
                {4,1,95}
        };
        networkDelayTime(times, 5, 1);

    }
    public static int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int a = 0; a < times.length; a++) {
            int[] point = times[a];
            int i = point[0];
            int j = point[1];
            int dist = point[2];
            Map<Integer, Integer> distancesI = map.getOrDefault(i, new HashMap<>());
            distancesI.put(j, dist);
            map.put(i, distancesI);
        }

        Set<Integer> visited = new HashSet();
        visited.add(k);

        int max = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        if (map.size() != 0 &&  map.get(k) != null) {
            for (int neighPoint : map.get(k).keySet()) {
                pq.offer(new int[]{k, neighPoint, map.get(k).get(neighPoint)});
            }
        }

        while (!pq.isEmpty()) {
            int[] closestPoint = pq.poll();
            if (!visited.contains(closestPoint[1])) {
                visited.add(closestPoint[1]);
                max = Math.max(max, closestPoint[2]);

                if (map.get(closestPoint[1]) != null) {
                    for (int nextPoint : map.get(closestPoint[1]).keySet()) {
                        if (!visited.contains(nextPoint)){
                            pq.offer(new int[]{closestPoint[1], nextPoint, closestPoint[2] + map.get(closestPoint[1]).get(nextPoint)});
                        }
                    }
                }
            }
        }

        if (visited.size() == n) {
            return max;
        }
        return -1;
    }
}
