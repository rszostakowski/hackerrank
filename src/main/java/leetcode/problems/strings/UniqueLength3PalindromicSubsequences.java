package leetcode.problems.strings;

import java.util.*;

public class UniqueLength3PalindromicSubsequences {
    public static void main(String[] args) {
        System.out.println(countPalindromicSubsequence("aabca"));
    }

    // this solution is to slow
    public static int countPalindromicSubsequence3(String s) {
        Set<String> set = new HashSet<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j < s.length(); j++) {
                if (chars[i] == chars[j]) {
                    for (int k = i + 1; k < j; k++) {
                        set.add("" + chars[i] + chars[k] + chars[j]);
                    }
                }
            }
        }
        return set.size();
    }

    public static int countPalindromicSubsequence(String s) {
        Set<String> set = new HashSet<>();
        char[] alphabetArray = new char[26];
        char[] chars = s.toCharArray();

        for (int i = 0; i < 26; i++) {
            alphabetArray[i] = (char) ('a' + i);
        }

        int n = s.length();
        for (char ch : alphabetArray) {
            int left = 0;
            int right = n-1;

            while(left < right) {
                if(chars[left] != ch) {
                    left++;
                }else if(chars[right] != ch) {
                    right--;
                } else {
                    for (int k = left + 1; k < right; k++) {
                        set.add("" + chars[left] + chars[k] + chars[right]);
                    }
                    break;
                }
            }
        }

        return set.size();
    }
}
