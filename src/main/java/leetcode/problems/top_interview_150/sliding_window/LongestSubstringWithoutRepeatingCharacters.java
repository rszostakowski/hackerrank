package leetcode.problems.top_interview_150.sliding_window;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        lengthOfLongestSubstring("abcabcbb");
    }

    // the best solution
    public static int lengthOfLongestSubstring(String s) {

        Set<Character> unique = new HashSet<>();

        int left = 0;
        int right = 0;

        int max = 0;
        while (right < s.length()) {
            char charRight = s.charAt(right);
            if (unique.contains(charRight)) {
                unique.remove(s.charAt(left));
                left++;
            } else {
                unique.add(charRight);
                max = Math.max(max, right - left + 1);
                right++;
            }
        }
        return max;
    }

    public static int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int maxSize = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet()).size();

        while(maxSize >= 2){
            for (int i = 0; i <= s.length()-maxSize; i++) {
                String toCheck = s.substring(i, i+ maxSize);
                int windowSize = toCheck.chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.toSet()).size();
                if (windowSize == maxSize) {
                    return maxSize;
                }
            }

            maxSize--;
        }
        return 1;
    }
}
