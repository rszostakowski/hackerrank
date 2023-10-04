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
            fromNode.add(new Flight(to, price));
            map.put(from, fromNode);
        }
        HashSet<Integer> res = new HashSet<>();
        List<Flight> path = new LinkedList<>();
        path.add(new Flight(src, 0));
        backtrack(map, res, path, src, dst, k);
        return res.stream().mapToInt(e -> e).min().orElse(-1);
    }

    public void backtrack(Map<Integer, List<Flight>> map,
                          Set<Integer> res,
                          List<Flight> path,
                          int node,
                          int dest,
                          int k) {
        if (node == dest){
            res.add(path.stream().map(fl -> fl.price).mapToInt(e-> e).sum());
            return;
        }

        if (path.size() > k+1) {
            return;
        }

        List<Flight> flights = map.getOrDefault(node, new LinkedList<>());
        for (Flight fl: flights) {
            if (!path.contains(fl) && path.size() <= k+1) {
                path.add(fl);
                System.out.println(path);
                backtrack(map, res, path, fl.node, dest, k);
                path.remove(path.size() - 1);
            }
        }
    }

    class Flight {
        int node;
        int price;

        public Flight(int to, int price) {
            this.node = to;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Flight{" +
                    "node=" + node +
                    ", price=" + price +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Flight flight = (Flight) o;

            return node == flight.node;
        }

        @Override
        public int hashCode() {
            return node;
        }
    }
}
