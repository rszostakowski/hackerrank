package leetcode.problems.strings;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    // dp solution : https://leetcode.com/problems/palindromic-substrings/solutions/105707/java-python-dp-solution-based-on-longest-palindromic-substring/
    public int longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap();
        for (char ch : chars) {
            map.put(ch, map.getOrDefault(ch, 0) +1);
        }

        boolean hasNotEven = false;
        int sum = 0;
        for (Integer val : map.values()){
            if(val % 2 == 0) {
                sum +=val;
            } else if (val > 2) {
                sum += (val-1) ;
                hasNotEven = true;
            } else {
                hasNotEven = true;
            }
        }

        return hasNotEven? sum +1: sum;
    }
}
