package leetcode.problems.graphs;

import java.util.*;

public class CheapestFlightsWithinKStops {
    public static void main(String[] args) {
        CheapestFlightsWithinKStops stops = new CheapestFlightsWithinKStops();

        int n = 4;
        int[][] flights = new int[][] {
                {0,1,100},
                {1,2,100},
                {2,0,100},
                {1,3,600},
                {2,3,200}
        };
        int src = 0;
        int dst = 3;
        int k = 1;
        stops.findCheapestPrice(n,  flights, src, dst, k);
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<Flight>> map = new HashMap<>();

        for (int[] flight: flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];

            List<Flight> fromNode = map.getOrDefault(from, new LinkedList<>());
            fromNode.add(new Flight(from, to, price));
            map.put(to, fromNode);
        }
        HashSet<Integer> res = new HashSet<>();
        backtrack(map, res, new HashSet<Integer>(), src, dst, k);
        return res.stream().mapToInt(e -> e).min().orElse(-1);
    }

    public void backtrack(Map<Integer, List<Flight>> map,
                          Set<Integer> res,
                          Set<Integer> subset,
                          int node,
                          int dest,
                          int k) {
        if (node == dest){
            res.add(subset.stream().mapToInt(e-> e).sum());
            return;
        }

        if (subset.size() > k) {
            return;
        }

        List<Flight> flights = map.getOrDefault(node, new LinkedList<>());
        for (Flight fl: flights) {
            if (!subset.contains(fl.to) && subset.size() <= 2) {
                subset.add(fl.price);
                System.out.println(subset);
                backtrack(map, res, subset, fl.to, dest, k);
                subset.remove(subset.size() - 1);
            }
        }
    }

    class Flight {
        int from;
        int to;
        int price;

        public Flight(int from, int to, int price) {
            this.from = from;
            this.to = to;
            this.price = price;
        }
    }
}
