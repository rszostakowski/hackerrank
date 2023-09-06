package leetcode.problems.graphs;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RedundantConnection {
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
}
