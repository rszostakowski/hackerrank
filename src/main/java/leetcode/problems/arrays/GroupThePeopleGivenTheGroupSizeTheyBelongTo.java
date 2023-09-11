package leetcode.problems.arrays;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GroupThePeopleGivenTheGroupSizeTheyBelongTo
{

    // improved solution
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> grouped = new HashMap<>();
        List<List<Integer>> res = new LinkedList();
        for (int i = 0; i < groupSizes.length; i++) {
            int group = groupSizes[i];
            List<Integer> existingGroups = grouped.computeIfAbsent(group, k -> new LinkedList<>());
            existingGroups.add(i);
            if (existingGroups.size() == group) {
                res.add(existingGroups);
                grouped.put(group, new LinkedList<>());
            }
        }
        return res;
    }

    // initial solution
    public List<List<Integer>> groupThePeople_old(int[] groupSizes) {
        Map<Integer, List<Integer>> grouped = new HashMap<>();

        for (int i = 0; i < groupSizes.length; i++) {
            int group = groupSizes[i];
            List<Integer> existingGroups = grouped.getOrDefault(group, new LinkedList<>());
            existingGroups.add(i);
            grouped.put(group, existingGroups);
        }

        List<List<Integer>> res = new LinkedList();

        for (int key : grouped.keySet()) {
            List<Integer> toSplit = grouped.get(key);

            List<List<Integer>> sublists = IntStream.range(0, toSplit.size() / key)
                    .mapToObj(i -> toSplit.subList(i * key, (i + 1) * key))
                    .collect(Collectors.toList());

            res.addAll(sublists);
        }
        return res;
    }
}
