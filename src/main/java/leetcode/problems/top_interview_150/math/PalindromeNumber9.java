package leetcode.problems.top_interview_150.math;

public class PalindromeNumber9 {

    public boolean isPalindrome(int x) {
        char[] chars = Integer.toString(x).toCharArray();

        int i = 0;
        int j = chars.length-1;

        while (i <j) {
            if (chars[i] != chars[j]) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    // old approach
    public boolean isPalindrome2(int x) {
        int initial = x;
        if (x < 0) {
            return false;
        }

        if (x == 0) {
            return true;
        }

        String result = "";
        while (x > 0) {
            result += x%10;
            x= x/10;
        }
        long reversed = Long.parseLong(result);
        return initial == reversed;
    }
}
