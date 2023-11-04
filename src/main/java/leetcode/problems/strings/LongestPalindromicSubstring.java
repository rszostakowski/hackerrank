package leetcode.problems.strings;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        LongestPalindromicSubstring longe = new LongestPalindromicSubstring();
        String babad = longe.longestPalindrome("babad");
        System.out.println(babad);
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        int msf = 0;
        String longest = "";
        for (int i = 0; i <n; i++) {
            for (int j = n-1; j >= i+msf; j--) {
                String sub = s.substring(i, j + 1);
                if(isPalindrome(sub)){
                    longest = sub;
                    msf = longest.length();
                }
            }
        }

        return longest;
    }

    private boolean isPalindrome(String s) {
        int length = s.length();
        if (length <= 1) {
            return true;
        }

        for (int left = 0, right = length - 1; left < right; left++, right--) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
        }

        return true;
    }

    // the best solution:
    //https://leetcode.com/problems/longest-palindromic-substring/solutions/2928/very-simple-clean-java-solution/
}
