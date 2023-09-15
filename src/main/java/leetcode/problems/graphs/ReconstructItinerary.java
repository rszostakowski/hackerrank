package leetcode.problems.graphs;

import java.util.*;
import java.util.stream.Collectors;

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

        ri.findItinerary(tickets);
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

        List<String> itinerary = ri.findItinerary(tickets);
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

        List<String> itinerary = ri.findItinerary(tickets);
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

        List<String> itinerary = ri.findItinerary(tickets);
        itinerary.forEach(System.out::println);
        //["JFK","ATL","PHX","LAX","JFK","ORD","PHL","ATL"]
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, RGraphNode> set = new HashMap();

        for (List<String> ticket: tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            RGraphNode fromNode = set.getOrDefault(from, new RGraphNode(from));
            RGraphNode toNode = set.getOrDefault(to, new RGraphNode(to));

            fromNode.flightsTo.add(toNode);
            toNode.flightsFrom.add(fromNode);
            set.put(from, fromNode);
            set.put(to, toNode);
        }

        ArrayList<String> results = new ArrayList<>();

        RGraphNode startingNode = set.get("JFK");
        results.add(startingNode.name);

        Stack<RGraphNode> st = new Stack<>();
        st.add(startingNode.getTopFlightTo());

        while (!st.isEmpty()) {
            RGraphNode node = st.pop();
            results.add(node.name);
            System.out.println("Visited: "+ node.name);
            if (node.flightsTo != null && node.flightsTo.size() != 0) {
                st.add(node.getTopFlightTo());
            }
        }

        return results;
    }


}

class RGraphNode {
    String name;

    public List<RGraphNode> flightsTo;
    public List<RGraphNode> flightsFrom;

    RGraphNode(String name) {
        this.name = name;
        flightsTo = new LinkedList<>();
        flightsFrom = new LinkedList<>();
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

