package leetcode.problems.strings;

public class PalindromicSubstrings {
    int count = 0;

    public int countSubstrings(String s) {
        int n = s.length();
        int num = n;

        for (int i = 0; i < n-1; i++) {
            for (int j = i+2; j <= n; j++) {
                String str = s.substring(i, j);
                //System.out.println("i: " + i + " j: " +j + " str: " + str);
                if (isPalindrome(str)) {
                    num++;
                }
            }
        }
        return num;
    }

    private boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }
        int left = 0;
        int right = s.length() -1;
        char[] chars = s.toCharArray();
        while (left < right) {
            if (chars[left] != chars[right])
                return false;
            left++;
            right--;
        }
        return true;
    }

    // the best solution
    // https://leetcode.com/problems/palindromic-substrings/solutions/105689/java-solution-8-lines-extendpalindrome/
    public int countSubstrings_best(String s) {
        if (s == null || s.length() == 0) return 0;

        for (int i = 0; i < s.length(); i++) { // i is the mid point
            extendPalindrome(s, i, i); // odd length;
            extendPalindrome(s, i, i + 1); // even length
        }

        return count;
    }

    private void extendPalindrome(String s, int left, int right) {
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++; left--; right++;
        }
    }
}
