package leetcode.problems.top_interview_150.graph_general;

import java.util.*;

public class CourseSchedule {
    public static void main(String[] args) {
        int[][] input = {{1,0}, {0,1}};
        System.out.println(canFinish(2, input));
    }
    static Map<Node,Node> visited = new HashMap<>();
    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        for (int[] prerequisite: prerequisites) {
            int course = prerequisite[0];
            int required = prerequisite[1];

            Node node = new Node(course);
            Node requiriedNode = new Node(required);
            if (visited.containsKey(node)) {
                Node stored = visited.get(node);
                if (visited.containsKey(requiriedNode)) {
                    Node storedRequired = visited.get(requiriedNode);
                    stored.neighbors.add(storedRequired);
                } else {
                    stored.neighbors.add(requiriedNode);
                }
            } else {
                node.neighbors.add(requiriedNode);
                visited.put(node, node);
                visited.put(requiriedNode, requiriedNode);
            }
        }

        return hasCycle(visited.values());
    }

    private static boolean hasCycle(Collection<Node> values) {
        Map<Node, Boolean> alreadyVisited = new HashMap<>();
        for (Node node: values) {
            if (alreadyVisited.containsKey(node)) {
                return true;
            } else {
                alreadyVisited.put(node, false);
                hasCycle(node.neighbors);
            }
        }
        return false;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
