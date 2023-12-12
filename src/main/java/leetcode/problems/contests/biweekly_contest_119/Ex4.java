package leetcode.problems.contests.biweekly_contest_119;

import leetcode.problems.graphs.MinCostToConnectAllPoints;

import java.util.*;

public class Ex4 {

    //https://leetcode.com/contest/biweekly-contest-119/problems/number-of-possible-sets-of-closing-branches/
    public static void main(String[] args) {
        Ex4 ex = new Ex4();

        if(ex.numberOfSets(3, 5,  new int[][]{{0, 1, 2}, {1, 2, 10}, {0, 2, 10}}) !=5) {
            throw new RuntimeException("1");
        }
        if(ex.numberOfSets(3, 5,  new int[][]{{0,1,20}, {0,1,10}, {1,2,2}, {0,2,2}}) !=7) {
            throw new RuntimeException("2");
        }
        if(ex.numberOfSets(1, 10,  new int[][]{}) !=2) {
            throw new RuntimeException("3");
        }
    }

    public int numberOfSets(int n, int maxDistance, int[][] roads) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
                int pointI = roads[i][0];
                int pointJ = roads[i][1];
                int dist = roads[i][2];
                Map<Integer, Integer> distancesI = map.getOrDefault(pointI, new HashMap<>());
                Map<Integer, Integer> distancesJ = map.getOrDefault(pointJ, new HashMap<>());
                distancesI.put(pointJ, dist);
                distancesJ.put(pointI, dist);
                map.put(pointI, distancesI);
                map.put(pointJ, distancesJ);
        }


        for (int i = 0; i < n; i++) {
            int startingPoint = i;

            Set<Integer> visited = Set.of();
            Map<Integer, Integer> whereToGo = map.get(startingPoint);

            //PriorityQueue<>
            for (Integer branch : whereToGo.keySet()) {
                Integer integer = whereToGo.get(branch);
                System.out.println(integer);
            }
            System.out.println(whereToGo);
        }
        return 0;
    }
}
