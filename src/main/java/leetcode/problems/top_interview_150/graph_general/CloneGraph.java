package leetcode.problems.top_interview_150.graph_general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph
{
    Map<Node,Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        Node newNode = new Node(node.val);
        visited.put(node, newNode);

        for (Node n: node.neighbors) {
            newNode.neighbors.add(cloneGraph(n));
        }
        return newNode;
    }
}