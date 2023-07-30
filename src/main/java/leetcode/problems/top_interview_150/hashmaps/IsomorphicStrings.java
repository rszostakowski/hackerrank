package leetcode.problems.top_interview_150.hashmaps;

import java.util.*;
import java.util.stream.Collectors;

public class IsomorphicStrings {

    public static void main(String[] args) {
        isIsomorphic("badc", "baba");
    }
    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Integer> m1 = new HashMap();

        for (char c : s.toCharArray()) {
            m1.put(c, m1.getOrDefault(c, 0) +1);
        }

        Map<Character, Integer> m2 = new HashMap();

        for (char c : t.toCharArray()) {
            m2.put(c, m2.getOrDefault(c, 0) +1);
        }

        for (int i= 0; i < s.length(); i++) {
            char iso1 = s.charAt(i);
            char iso2 = t.charAt(i);
            if (m1.get(iso1) != m2.get(iso2)) {
                return false;
            }
        }
        return true;
    }


}
