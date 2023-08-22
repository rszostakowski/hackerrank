package leetcode.problems.top_interview_150.graph_general;

import java.util.*;

public class CourseSchedule2 {
    public static void main(String[] args) {
        int[][] input = {{1,0},{2,0},{3,1},{3,2}};
        System.out.println(findOrder(2, input));
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
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

        return getOrderWhileRemovingDependencies(numCourses, nodes);
    }

    private static int[] getOrderWhileRemovingDependencies(int numCourses, Map<Integer, List<Integer>> nodes) {
        Set<Integer> keys = nodes.keySet();

        Set<Integer> withoutDependencies = new HashSet<>();
        List<Integer> result = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (!keys.contains(i)) {
                withoutDependencies.add(i);
                result.add(i);
            }
        }

        for (int i = 0; i < 2500; i++) {
            for (int removed: withoutDependencies) {
                nodes.remove(removed);
            }
            if (nodes.size() == 0) {
                return result.stream()
                        .mapToInt(Integer::intValue)
                        .toArray();
            }
            removeDependencies(nodes, withoutDependencies, result);
        }

        return new int[]{};
    }

    private static void removeDependencies(Map<Integer, List<Integer>> nodes, Set<Integer> withoutDependencies, List<Integer> result) {
        Set<Integer> nodeKeys = nodes.keySet();
        for (int key : nodeKeys) {
            List<Integer> neighbours = nodes.get(key);
            neighbours.removeAll(withoutDependencies);
            if (neighbours.size() == 0) {
                withoutDependencies.add(key);
                result.add(key);
            }
        }
    }
}
