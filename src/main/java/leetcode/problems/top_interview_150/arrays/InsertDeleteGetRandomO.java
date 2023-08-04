package leetcode.problems.top_interview_150.arrays;

import java.util.*;
import java.util.stream.Collectors;

public class InsertDeleteGetRandomO {
    Map<Integer, Integer> map;
    public InsertDeleteGetRandomO() {
        map = new HashMap();
    }

    public boolean insert(int val) {
        boolean hasEl = map.containsKey(val);
        if (!hasEl) {
            map.put(val, 1);
        }
        return !hasEl;
    }

    public boolean remove(int val) {
        boolean hasEl = map.containsKey(val);
        if (hasEl) {
            map.remove(val);
        }

        return hasEl;
    }

    public int getRandom() {
        Random rand = new Random();
        List<Integer> keys = new ArrayList<>(map.keySet());
        int numOfElements = keys.size();
        return keys.get(rand.nextInt(numOfElements));
    }
}
