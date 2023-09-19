package leetcode.problems.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FirstUniqueCharacterInString {
    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap();
        Set<Character> atLeast2 = new HashSet();
        for (int i = 0; i< chars.length; i++) {
            char current = chars[i];
            if (!map.containsKey(current) && !atLeast2.contains(current)) {
                map.put(current, i);
            } else {
                map.remove(current);
                atLeast2.add(current);
            }
        }

        return map.values().stream().sorted().findFirst().orElse(-1);
    }

    // the fastest solution:
    public int firstUniqChar_best(String s) {
        int freq [] = new int[26];
        for(int i = 0; i < s.length(); i ++)
            freq [s.charAt(i) - 'a'] ++;
        for(int i = 0; i < s.length(); i ++)
            if(freq [s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }
}
