package leetcode.problems.top_interview_150.sliding_window;

import java.util.Arrays;

public class PermutationInString {

    public static void main(String[] args) {
        String s1 = "adc", s2 = "dcda";
        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        int n = s2.length();
        int left = 0;
        int right = s1.length();

        char[] s1Chars = s1.toCharArray();
        Arrays.sort(s1Chars);
        while (right <= n && left < right) {
            String sub = s2.substring(left, right);
            char[] subChars = sub.toCharArray();
            Arrays.sort(subChars);
            if(Arrays.equals(subChars, s1Chars)) {
                return true;
            }
            left++;
            right++;
        }
        return false;
    }

    // match better solution
    public boolean checkInclusionBest(String s1, String s2) {
        int n = s1.length();
        int[] freq = new int[26];
        int m = s2.length();
        for (int i = 0; i < n; i++) {
            freq[s1.charAt(i) - 'a']++;
        }
        int[] freq2 = new int[26];
        for (int i = 0; i < m; i++) {
            freq2[s2.charAt(i) - 'a']++;
            if (i >= n) {
                freq2[s2.charAt(i - n) - 'a']--;
            }
            if (Arrays.equals(freq, freq2))
                return true;
        }
        return false;
    }
}
