package leetcode.problems.graphs;

import java.util.*;

public class MinCostToConnectAllPoints
{

    //https://www.geeksforgeeks.org/prims-minimum-spanning-tree-mst-greedy-algo-5/
    public static void main(String[] args) {
        List<List<Integer>> input = Arrays.asList(
                Arrays.asList(0, 0),
                Arrays.asList(2, 2),
                Arrays.asList(3, 10),
                Arrays.asList(5, 2),
                Arrays.asList(7, 0)
        );

        int[][] result = input.stream()
                .map(list -> list.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);

        minCostConnectPoints(result);
    }

    public static void main2(String[] args) {
        List<List<Integer>> input = Arrays.asList(
                Arrays.asList(0, 0),
                Arrays.asList(1, 1),
                Arrays.asList(1, 0),
                Arrays.asList(-1, 1)
        );

        int[][] result = input.stream()
                .map(list -> list.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);

        minCostConnectPoints(result);
    }
    //[[0,0],[1,1],[1,0],[-1,1]]
    public static int minCostConnectPoints(int[][] points) {
        int n = points.length;
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int[] point1 = points[i];
                int[] point2 = points[j];

                int dist = dist(point1, point2);
                Map<Integer, Integer> distancesI = map.getOrDefault(i, new HashMap<>());
                Map<Integer, Integer> distancesJ = map.getOrDefault(j, new HashMap<>());
                distancesI.put(j, dist);
                distancesJ.put(i, dist);
                map.put(i, distancesI);
                map.put(j, distancesJ);
            }
        }

        int counter = 0;
        int numOfNodes = 0;

        Set<Integer> visited = new HashSet<>();
        visited.add(0);

        PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e.distance));
        if (map.size() != 0) {
            for (int nextPoint : map.get(0).keySet()) {
                minHeap.offer(new Edge(0, nextPoint, map.get(0).get(nextPoint)));
            }

            while (numOfNodes < n - 1) {
                Edge edge = minHeap.poll();
                int nextPoint = edge.point2;

                if (!visited.contains(nextPoint)) {
                    counter += edge.distance;
                    visited.add(nextPoint);
                    numOfNodes++;

                    for (int adjacentPoint : map.get(nextPoint).keySet()) {
                        if (!visited.contains(adjacentPoint)) {
                            // always add the next possible closest point
                            minHeap.offer(new Edge(nextPoint, adjacentPoint, map.get(nextPoint).get(adjacentPoint)));
                        }
                    }
                }
            }
        }

        return counter;
    }

    private static class Edge {
        int point1;
        int point2;
        int distance;

        public Edge(int point1, int point2, int distance) {
            this.point1 = point1;
            this.point2 = point2;
            this.distance = distance;
        }
    }

    static int dist(int[] first, int[] second) {
        return Math.abs(first[0] - second[0]) + Math.abs(first[1] - second[1]);
    }
}