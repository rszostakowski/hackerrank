package leetcode.problems.maps;

import java.util.*;

public class GroupAnagrams49 {

    public List<List<String>> groupAnagrams(String[] strs) {

        int n = strs.length;
        Map<String, LinkedList<String>> grouped = new HashMap();

        for (int i = 0; i<n;  i++) {
            String current = strs[i];
            char[] input = current.toCharArray();
            Arrays.sort(input);
            String sortedInput = new String(input);
            LinkedList<String> groupedList = grouped.getOrDefault(sortedInput, new LinkedList<String>()); // has to be not inlined
            groupedList.add(current);
            grouped.put(sortedInput, groupedList);
        }

        return new ArrayList<>(grouped.values()); // here a nice part
    }
}
