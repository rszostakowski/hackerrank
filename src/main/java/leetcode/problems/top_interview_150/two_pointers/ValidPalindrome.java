package leetcode.problems.top_interview_150.two_pointers;

import java.util.stream.Collectors;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "");

        int n = s.length();
        for (int i = 0,  j = n-1; i < j; i++, j--) {
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))  {
                return false;
            }
        }

        return true;
    }
}
