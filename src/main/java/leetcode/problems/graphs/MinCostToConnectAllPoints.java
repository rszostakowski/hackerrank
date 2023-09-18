package leetcode.problems.graphs;

import java.util.*;

public class MinCostToConnectAllPoints
{
    public static void main2(String[] args) {
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

    public static void main(String[] args) {
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
        Map<Integer, Map<Integer, Integer>> map = new HashMap();
        int n = points.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
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

        boolean[] visited = new boolean[n];
        visited[0] = true;

        // the idea is always consider all connected points and from all of them find the one not connected
        while(numOfNodes < n-1) {
            int minClosestDist = Integer.MAX_VALUE;
            int secondPointIdx = 0;
            int firstPointIdx = 0;

            for (int i = 0; i < n;i++) {
                if (visited[i]) {
                    Map<Integer, Integer> distances = map.get(i);
                        for (Integer pointIdx :distances.keySet()) {
                            if (!visited[pointIdx]) {
                                Integer dist = distances.get(pointIdx);
                                if (minClosestDist > dist) {
                                    minClosestDist = dist;
                                    secondPointIdx = pointIdx;
                                    firstPointIdx = i;
                                }
                            }
                        }
                }
            }
            counter += minClosestDist;
            removeConnection(visited, map, firstPointIdx, secondPointIdx);
            visited[secondPointIdx] = true;

            System.out.println("Connecting " + firstPointIdx + " with " + secondPointIdx +" dist: " + minClosestDist);
            numOfNodes++;
        }

        System.out.println("counter: " + counter);
        return counter;
    }

    private static void removeConnection(
            boolean[] visited,
            Map<Integer, Map<Integer, Integer>> closestDist,
            int firstPointIdx,
            int secondPointIdx) {

        Map<Integer, Integer> dists1 = closestDist.get(firstPointIdx);
        dists1.remove(secondPointIdx);

        Map<Integer, Integer> dists2 = closestDist.get(secondPointIdx);
        dists2.remove(firstPointIdx);

        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                Map<Integer, Integer> visitedDists = closestDist.get(i);
                visitedDists.remove(secondPointIdx);
            }
        }
    }

    static int dist(int[] first, int[] second) {
        return Math.abs(first[0]-second[0]) + Math.abs(first[1]-second[1]);
    }
}
