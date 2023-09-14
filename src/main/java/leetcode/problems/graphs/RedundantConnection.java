package leetcode.problems.graphs;

import java.util.*;

public class RedundantConnection {

    public static void main(String[] args) {
        RedundantConnection redundantConnection = new RedundantConnection();
        int[][] edges = new int[][] {
                {9,10},{5,8},{2,6},{1,5},{3,8},{4,9},{8,10},{4,10},{6,8},{7,9}
        };
        redundantConnection.findRedundantConnection2(edges);
    }
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> map = new LinkedHashMap();
        for (int[] edge : edges) {
            List<Integer> nodes = map.getOrDefault(edge[0], new ArrayList<>());
            nodes.add(edge[1]);
            map.put(edge[0], nodes);
        }

        for (int key : map.keySet()) {
            List<Integer> nodes = map.get(key);
            if(nodes.size() == 3) {
                Integer last = nodes.get(nodes.size() - 1);
                //findCycle(key, first)
                //findCycle(key, second)
                //findCycle(key, third)
            }
        }
        throw new RuntimeException();
    }

    public int[] findRedundantConnection2(int[][] edges) {
        Arrays.sort(edges, Comparator.comparingInt((int[] row) -> Math.min(row[0], row[1])));


        Set<Integer> visited = new HashSet();
        List<int[]> toRemove = new LinkedList();
        for (int[] edge : edges) {
            if (visited.contains(edge[0]) && visited.contains(edge[1])) {
                toRemove.add(edge);
            }
            visited.add(edge[0]);
            visited.add(edge[1]);
        }

        if (toRemove.size() != 0) {
            return toRemove.get(toRemove.size()-1);
        }
        return new int[2];
    }

    private boolean isCycle(int[] edge) {

        return false;
    }
}
