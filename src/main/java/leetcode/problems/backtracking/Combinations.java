package leetcode.problems.backtracking;

import java.util.*;

public class Combinations {
    public static void main(String[] args) {
        List<List<Integer>> combine = combine(13, 10);
        System.out.println(combine);
    }
    public static List<List<Integer>> combine(int n, int k) {
        Set<List<Integer>> results = new HashSet<>();
        if (n == k) {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < k;  i++) {
                result.add(i);
            }
            results.add(result);
            return results.stream()
                    .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        }

        combine(new HashSet(), n, k, 0,  results);
        return results.stream()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

    }

    public static void combine(Set<Integer> partial, int n, int k , int offset, Set<List<Integer>> results) {
        if (partial.size() == k) {
            results.add(new LinkedList<Integer>(partial));
            return;
        }

        for (int i = 1; i<=n; i++)  {
            if (!partial.contains(i)){
                Set<Integer> newPartial = new HashSet<Integer>(partial);
                newPartial.add(i);
                System.out.println(newPartial);
                combine(newPartial, n, k , offset + 1,  results);
            }
        }
    }
}
