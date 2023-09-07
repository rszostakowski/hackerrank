package leetcode.problems.graphs;

import java.util.*;

public class NumberOfConnectedComponentsInUndirectedGraph {

    // I am not proud of this solution again
    public int countComponents(int n, int[][] edges) {
        Arrays.sort(edges, Comparator.comparingInt((int[] row) -> Math.min(row[0], row[1])));

        List<Set<Integer>> visited = new LinkedList();
        for (int[] edge : edges) {
            boolean found = false;
            for (Set<Integer> set : visited) {
                if (set.contains(edge[0]) || set.contains(edge[1])) {
                    found = true;
                    set.add(edge[0]);
                    set.add(edge[1]);
                    break;
                }
            }

            if (!found) {
                Set<Integer> set = new HashSet();
                set.add(edge[0]);
                set.add(edge[1]);
                visited.add(set);
            }
        }

        List<Set<Integer>> mergedSets = mergeSets(visited);
        int elementInComponents = 0;
        for (Set<Integer> set : mergedSets) {
            elementInComponents += set.size();
        }

        if ( (n - elementInComponents) > 0 ) {
            return mergedSets.size() + n - elementInComponents;
        }

        return visited.size();
    }

    public static List<Set<Integer>> mergeSets(List<Set<Integer>> inputSets) {
        List<Set<Integer>> mergedSets = new ArrayList<>();

        for (Set<Integer> currentSet : inputSets) {
            Set<Integer> mergedSet = new HashSet<>();
            List<Set<Integer>> setsToMerge = new ArrayList<>();

            // Check if the current set overlaps with any existing merged sets
            for (Set<Integer> existingSet : mergedSets) {
                if (hasCommonElements(currentSet, existingSet)) {
                    setsToMerge.add(existingSet);
                }
            }

            // Merge the current set with the sets that overlap
            mergedSet.addAll(currentSet);
            for (Set<Integer> setToMerge : setsToMerge) {
                mergedSet.addAll(setToMerge);
                mergedSets.remove(setToMerge);
            }

            // Add the merged set to the result list
            mergedSets.add(mergedSet);
        }

        return mergedSets;
    }

    // Helper function to check if two sets have common elements
    private static boolean hasCommonElements(Set<Integer> set1, Set<Integer> set2) {
        for (Integer element : set1) {
            if (set2.contains(element)) {
                return true;
            }
        }
        return false;
    }
}
