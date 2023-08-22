package leetcode.problems.top_interview_150.graph_general;

import java.util.*;

public class CourseSchedule {
    public static void main(String[] args) {
        int[][] input = {{1, 0}, {0, 1}};
        System.out.println(canFinish(2, input));
    }


    static Map<Integer, Boolean> alreadyVisited = new HashMap<>();
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> nodes = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int required = prerequisite[1];

            if (nodes.containsKey(course)) {
                List<Integer> prerequisities = nodes.get(course);
                prerequisities.add(required);
            } else {
                ArrayList<Integer> prerquisities = new ArrayList<>();
                prerquisities.add(required);
                nodes.put(course, prerquisities);
            }
        }

        return hasCycle(nodes);
    }

    private static boolean hasCycle(Map<Integer, List<Integer>> nodes) {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> onStack = new HashSet<>();

        for (int node : nodes.keySet()) {
            if (!visited.contains(node)) {
                if (hasCycleDFS(node, nodes, visited, onStack)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean hasCycleDFS(int node, Map<Integer, List<Integer>> nodes, Set<Integer> visited, Set<Integer> onStack) {
        visited.add(node);
        onStack.add(node);

        List<Integer> neighbours = nodes.getOrDefault(node, new ArrayList<>());
        for (int neighbor : neighbours) {
            if (!visited.contains(neighbor)) {
                if (hasCycleDFS(neighbor, nodes, visited, onStack)) {
                    return true;
                }
            } else if (onStack.contains(neighbor)) {
                return true;
            }
        }

        onStack.remove(node);
        return false;
    }
}
