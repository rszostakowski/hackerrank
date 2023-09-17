package leetcode.problems.strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfString {

    public String reverseVowels(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        int left = 0;
        int right = n - 1;

        while (left < right) {
            while (left < right && !vowels.contains(chars[left])) {
                left++;
            }
            while (left < right && !vowels.contains(chars[right])) {
                right--;
            }

            if (left < right) {
                char temp = chars[right];
                chars[right] = chars[left];
                chars[left] = temp;
                left++;
                right--;
            }
        }

        return new String(chars);
    }
}
