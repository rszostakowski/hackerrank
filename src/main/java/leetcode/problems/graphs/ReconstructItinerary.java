package leetcode.problems.graphs;

import java.util.*;
import java.util.stream.Collectors;


// this describes this problem very well
// https://www.geeksforgeeks.org/hierholzers-algorithm-directed-graph/
// there is also a bactracking solution https://leetcode.com/problems/reconstruct-itinerary/solutions/537998/java-dfs-backtracking/
public class ReconstructItinerary {
    public static void main1(String[] args) {

        // [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
        ReconstructItinerary ri = new ReconstructItinerary();
        List<String[]> input = Arrays.asList(
                new String[]{"MUC", "LHR"},
                new String[]{"JFK", "MUC"},
                new String[]{"SFO", "SJC"},
                new String[]{"LHR", "SFO"}
        );

        List<List<String>> tickets = input.stream()
                .map(Arrays::asList)
                .collect(Collectors.toList());

        ri.findItinerary_works(tickets);
    }

    public static void main55(String[] args) {

        ReconstructItinerary ri = new ReconstructItinerary();
        List<String[]> input = Arrays.asList(
                new String[]{"JFK","SFO"},
                new String[]{"JFK","ATL"},
                new String[]{"SFO","ATL"},
                new String[]{"ATL","JFK"},
                new String[]{"ATL","SFO"}
        );

        List<List<String>> tickets = input.stream()
                .map(Arrays::asList)
                .collect(Collectors.toList());

        List<String> itinerary = ri.findItinerary_works(tickets);
        itinerary.forEach(System.out::println);
        // ["JFK","ATL","JFK","SFO","ATL","SFO"]
    }

    public static void main(String[] args) {
        ReconstructItinerary ri = new ReconstructItinerary();
        List<String[]> input = Arrays.asList(
                new String[]{"JFK","NRT"},
                new String[]{"JFK","KUL"},
                new String[]{"NRT","JFK"}
        );

        List<List<String>> tickets = input.stream()
                .map(Arrays::asList)
                .collect(Collectors.toList());

        List<String> itinerary = ri.findItinerary_works(tickets);
        itinerary.forEach(System.out::println);
    }

    public static void main5(String[] args) {
        ReconstructItinerary ri = new ReconstructItinerary();
        List<String[]> input = Arrays.asList(
                new String[]{"JFK","ATL"},
                new String[]{"ORD","PHL"},
                new String[]{"JFK","ORD"},
                new String[]{"PHX","LAX"},
                new String[]{"LAX","JFK"},
                new String[]{"PHL","ATL"},
                new String[]{"ATL","PHX"}
        );

        List<List<String>> tickets = input.stream()
                .map(Arrays::asList)
                .collect(Collectors.toList());

        List<String> itinerary = ri.findItinerary_works(tickets);
        itinerary.forEach(System.out::println);
        //["JFK","ATL","PHX","LAX","JFK","ORD","PHL","ATL"]
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        // Build the graph with destinations sorted in reverse order
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            graph.computeIfAbsent(from, k -> new PriorityQueue<>()).offer(to);
        }

        List<String> result = new ArrayList<>();
        result.add("JFK");
        dfs_with_backtracing(graph, "JFK", result, tickets.size()+1);
        return result;
    }

    private boolean dfs_with_backtracing(Map<String, PriorityQueue<String>> graph, String node, List<String> result, int n) {
        if (result.size() == n) {
            return true;
        }

        PriorityQueue<String> neighs = graph.get(node);

        // backtracing
        if (neighs == null || neighs.isEmpty())
            return false;

        PriorityQueue<String> temp = new PriorityQueue<>(neighs);
        while (!neighs.isEmpty()) {
            String polled = neighs.poll();
            result.add(polled);
            System.out.println(polled);
            boolean valid = dfs_with_backtracing(graph, polled, result, n);
            if (valid)
                return true;
            else  {
                neighs.add(polled);
                result.remove(result.size() - 1);
            }
        }

        return false;
    }

    public List<String> findItineraryBest(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        // Build the graph with destinations sorted in reverse order
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            graph.computeIfAbsent(from, k -> new PriorityQueue<>()).offer(to);
        }

        List<String> result = new ArrayList<>();
        dfs(graph, "JFK", result);
        Collections.reverse(result); // Reverse the result to get the correct order
        return result;
    }

    private void dfs(Map<String, PriorityQueue<String>> graph, String node, List<String> result) {
        PriorityQueue<String> neighbors = graph.get(node);

        while (neighbors != null && !neighbors.isEmpty()) {
            String nextNode = neighbors.poll();
            dfs(graph, nextNode, result);
        }

        result.add(node);
    }

    // works, my initial crazy solution
    public List<String> findItinerary_works(List<List<String>> tickets) {
        Map<String, RGraphNode> map = new HashMap();

        for (List<String> ticket: tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            RGraphNode fromNode = map.getOrDefault(from, new RGraphNode(from));
            RGraphNode toNode = map.getOrDefault(to, new RGraphNode(to));

            fromNode.flightsTo.add(toNode);
            map.put(from, fromNode);
            map.put(to, toNode);
        }

        LinkedList<String> results = new LinkedList<>();

        RGraphNode startingNode = map.get("JFK");
        Stack<RGraphNode> st = new Stack<>();
        st.add(startingNode);

        while (!st.isEmpty()) {
            RGraphNode node = st.peek();
            if (node.flightsTo != null && node.flightsTo.size() != 0) {
                st.add(node.getTopFlightTo());
            } else {
                results.addFirst(st.pop().name);
            }
        }

        return results;
    }


}

class RGraphNode {
    String name;

    public List<RGraphNode> flightsTo;

    RGraphNode(String name) {
        this.name = name;
        flightsTo = new LinkedList<>();
    }

    public RGraphNode getTopFlightTo() {
        PriorityQueue<RGraphNode> pq = new PriorityQueue<>(nodeComparator);
        pq.addAll(flightsTo);
        RGraphNode node = pq.poll();
        flightsTo.remove(node);
        return node;
    }

    Comparator<RGraphNode> nodeComparator = (node1, node2) -> {
        // Check for null values
        if (node1.flightsTo == null && node2.flightsTo == null) {
            return 0;
        } else if (node1.flightsTo == null) {
            return -1; // node1 is null, move it before node2
        } else if (node2.flightsTo == null) {
            return 1; // node2 is null, move it before node1
        }

        // Compare based on flightsTo size (ascending)
        if (node2.flightsTo.size() != 0  && node1.flightsTo.size() !=0) {
            return node1.name.compareTo(node2.name);
        }
        if (node1.flightsTo.size() != 0) {
            return -1;
        }
        if (node2.flightsTo.size() != 0) {
            return 1;
        }

        return 0;
    };
}



/*
EZE
TIA
HBA
AXA
JFK
ANU
ADL
AUA
EZE TIA
EZE HBA
AXA TIA
JFK AXA
ANU JFK
ADL ANU
TIA AUA
ANU AUA
ADL EZE
ADL EZE
EZE ADL
AXA EZE
AUA AXA
JFK AXA
AXA AUA
AUA ADL
ANU EZE
TIA ADL
EZE ANU
AUA ANU
 */

