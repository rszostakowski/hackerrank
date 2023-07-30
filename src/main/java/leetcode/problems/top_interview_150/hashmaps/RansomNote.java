package leetcode.problems.top_interview_150.hashmaps;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> ransomMap = new HashMap();

        for (char c : ransomNote.toCharArray()) {
            ransomMap.put(c, ransomMap.getOrDefault(c, 0) +1);
        }

        Map<Character, Integer> magazineMap = new HashMap();

        for (char c : magazine.toCharArray()) {
            magazineMap.put(c, magazineMap.getOrDefault(c, 0) +1);
        }

        for (char c: ransomMap.keySet()) {
            if (!magazineMap.containsKey(c) ||ransomMap.get(c) > magazineMap.get(c)) {
                return false;
            }
        }

        return true;
    }
}
