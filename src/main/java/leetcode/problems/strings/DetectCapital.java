package leetcode.problems.strings;

public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        char[] chars = word.toCharArray();

        boolean firstUpper = Character.isUpperCase(chars[0]);
        if (firstUpper && chars.length > 1) {
            boolean secondUpper = Character.isUpperCase(chars[1]);
            for (int i = 2; i < chars.length; i++) {
                if (secondUpper != Character.isUpperCase(chars[i])) {
                    return false;
                }
            }
        } else {
            for (int i = 1; i < chars.length; i++) {
                if (Character.isUpperCase(chars[i])) {
                    return false;
                }
            }
        }

        return true;
    }

    public int maximumScore(int[] A, int k) {
        int res = A[k], mini = A[k], i = k, j = k, n = A.length;
        while (i > 0 || j < n - 1) {
            if (i == 0)
                ++j;
            else if (j == n - 1)
                --i;
            else if (A[i - 1] < A[j + 1])
                ++j;
            else
                --i;
            mini = Math.min(mini, Math.min(A[i], A[j]));
            res = Math.max(res, mini * (j - i + 1));
        }
        return res;
    }
}
