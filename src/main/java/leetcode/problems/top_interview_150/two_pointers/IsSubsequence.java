package leetcode.problems.top_interview_150.two_pointers;

public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {

        int i = 0;
        int j = 0;
        while (i < t.length()) {
            if (t.charAt(i) == s.charAt(j)) {
                j++;
                if (t.length() == j) {
                    return true;
                }
            }
            i++;
        }

        return false;
    }
}
