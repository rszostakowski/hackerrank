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
        Map<Integer, SortedMap<Integer, List<Integer>>> map = new HashMap();
        int n = points.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int[] point1 = points[i];
                int[] point2 = points[j];

                int dist = dist(point1, point2);
                SortedMap<Integer, List<Integer>> distancesI = map.getOrDefault(i, new TreeMap<>());
                SortedMap<Integer, List<Integer>> distancesJ = map.getOrDefault(j, new TreeMap<>());
                distancesI.computeIfAbsent(dist,  k -> new ArrayList<>()).add(j);
                distancesJ.computeIfAbsent(dist,  k -> new ArrayList<>()).add(i);
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
            SortedMap<Integer, List<Integer>> minFirstDistances = null;
            int minPointIdx = 0;
            int firstPointIdx = 0;

            for (int i = 0; i < n;i++) {
                if (visited[i]) {
                    SortedMap<Integer, List<Integer>> firstDistances = map.get(i);

                    for (Integer key : firstDistances.keySet()) {
                        for (Integer pointIdx :firstDistances.get(key)) {
                            if (!visited[pointIdx]) {
                                if (minClosestDist > key) {
                                    minClosestDist =  key;
                                    minFirstDistances = firstDistances;
                                    minPointIdx = pointIdx;
                                    firstPointIdx = i;
                                }
                            }
                        }
                    }
                }
            }
            counter += minClosestDist;
            removeConnection(minFirstDistances, minClosestDist, firstPointIdx);
            SortedMap<Integer, List<Integer>> secondDistances = map.get(minPointIdx);
            removeConnection(secondDistances, minClosestDist, minPointIdx);
            visited[minPointIdx] = true;

            System.out.println("Connecting " + firstPointIdx + " with " + minPointIdx +" dist: " + minClosestDist);
            numOfNodes++;
        }

        System.out.println("counter: " + counter);
        return counter;
    }

    private static void removeConnection(
            SortedMap<Integer, List<Integer>> firstDistances,
            Integer closestDist,
            int pointIdx) {
        List<Integer> closestPoints = firstDistances.get(closestDist);
        if (closestPoints.size() == 1) {
            firstDistances.remove(closestDist);
        } else {
            closestPoints.remove((Integer) pointIdx);
        }
    }

    static int dist(int[] first, int[] second) {
        return Math.abs(first[0]-second[0]) + Math.abs(first[1]-second[1]);
    }
}
