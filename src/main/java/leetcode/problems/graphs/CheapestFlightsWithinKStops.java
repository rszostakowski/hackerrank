package leetcode.problems.graphs;

import java.util.*;

public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<Flight>> map = new HashMap();

        for (int[] flight: flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];

            List<Flight> fromNode = map.getOrDefault(from, new LinkedList<>());
            fromNode.add(new Flight(from, to, price));
            map.put(to, fromNode);
        }

        return 0;
    }

    public void backtrack(Map<Integer, List<Flight>> map, Set<Integer> res, List<Integer> subset, int startIndex) {
        res.add(new ArrayList<>(subset));

        for (int i = startIndex; i < nums.length; i++) {
            subset.add(nums[i]);
            System.out.println(subset);
            backtrack(nums, res, subset, i + 1);
            subset.remove(subset.size() - 1);
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
