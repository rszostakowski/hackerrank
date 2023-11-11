package leetcode.problems.strings;

public class LongestUncommonSubsequence1 {

    public static void main(String[] args) {
        System.out.println(findLUSlength("aefawfawfawfaw", "aefawfeawfwafwaef"));
    }
    public static int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}
