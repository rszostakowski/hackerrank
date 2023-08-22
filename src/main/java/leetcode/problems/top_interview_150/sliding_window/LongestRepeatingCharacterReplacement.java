package leetcode.problems.top_interview_150.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        System.out.println(characterReplacementFromCommentSection("AABABBA", 1));
    }

    public static int characterReplacement(String s, int k) {
        Map<Character, Integer> unique = new HashMap<>();
        int right = 0;
        int left = 0;
        int max = 0;

        while (right < s.length() && left < s.length()) {
            char charRight = s.charAt(right);
            unique.put(charRight, unique.getOrDefault(charRight, 0) + 1);
            Result res = maxSoFar(s, unique);
            if ((res.otherThanMax > k)) {
                char keyToDelete = s.charAt(left++);
                unique.put(keyToDelete, unique.getOrDefault(keyToDelete, 1) - 1);
            }
            res = maxSoFar(s, unique);
            max = Math.max(res.sumOfValues, max);
            right++;
        }
        return max;
    }

    private static Result maxSoFar(String s, Map<Character, Integer> unique) {
        int maxOccurenceVal = Integer.MIN_VALUE;
        int sumOfValues = 0;
        for (Character chKey:  unique.keySet()) {
            int val = unique.get(chKey);
            if (val >= maxOccurenceVal) {
                maxOccurenceVal = val;
            }
            sumOfValues += val;
        }

        int otherThanMax = sumOfValues - maxOccurenceVal;
        return new Result(otherThanMax, sumOfValues);
    }

    // the best solution from the internet
    // https://leetcode.com/problems/longest-repeating-character-replacement/solutions/91271/java-12-lines-o-n-sliding-window-solution-with-explanation/
    public static int characterReplacementFromCommentSection(String s, int k) {
        int len = s.length();
        int[] count = new int[26];
        int start = 0, maxCount = 0, maxLength = 0;
        for (int end = 0; end < len; end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
            while (end - start + 1 - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

    // more readable solution
    // https://leetcode.com/problems/longest-repeating-character-replacement/solutions/358879/java-solution-explained-easy-to-understand-for-interviews/
    public int characterReplacementBest(String s, int k) {
        int[] freq = new int[26];
        int mostFreqLetter = 0;
        int left = 0;
        int max = 0;

        for(int right = 0; right < s.length(); right++){
            freq[s.charAt(right) - 'A']++;
            mostFreqLetter = Math.max(mostFreqLetter, freq[s.charAt(right) - 'A']);

            int lettersToChange = (right - left + 1) - mostFreqLetter;
            if(lettersToChange > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
}
class Result {
    public Result(int otherThanMax, int sumOfValues) {
        this.otherThanMax = otherThanMax;
        this.sumOfValues = sumOfValues;
    }
    public int otherThanMax;
    public int sumOfValues;
}