package leetcode.problems.contests.biweekly_contest_112;

import java.util.Arrays;

public class CheckIfStringsCanBeMadeEqualWithOperations2 {

    public static void main(String[] args) {
        CheckIfStringsCanBeMadeEqualWithOperations2 ex2 = new CheckIfStringsCanBeMadeEqualWithOperations2();
        //ex1.canBeEqual("ppeb", "ebpp");
        //ex1.canBeEqual("xbcx", "cxxb");
        //ex1.canBeEqual("ffww", "wwff");
        //ex1.canBeEqual("ifjz", "jzfi");
        ex2.checkStrings("abcd", "cdab");
    }

    public boolean checkStrings(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        if (canBeEqualInitial(s1, s2)) {
            char[] chars1 = s1.toCharArray();
            char[] chars2 = s2.toCharArray();
            for (int i = 0; i <s1.length(); i++) {
                char desired = chars2[i];
                if (desired != chars1[i]) {
                    // Choose any two indices i and j such that i < j and the difference j - i is even,
                    // then swap the two characters at those indices in the string.
                    boolean isFound = false;
                    for (int j = i+2; j < s1.length(); j+=2) {
                        if (chars1[j] == desired) {
                            isFound = true;
                            chars1 = swap(chars1, i, j);
                            break;
                        }
                    }

                    if (!isFound)
                        return false;
                }
            }

            return new String(chars1).equals(s2);
        }

        return false;
    }

    private char[] swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return chars;
    }

    private boolean canBeEqualInitial(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] charCount = new int[26];
        for (char c : s1.toCharArray()) {
            charCount[c - 'a']++;
        }

        for (char c : s2.toCharArray()) {
            charCount[c - 'a']--;
        }

        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
