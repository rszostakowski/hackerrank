package leetcode.problems.strings;

public class ReverseString2 {
    public static void main(String[] args) {
        ReverseString2 reverseString2 = new ReverseString2();
        System.out.println(reverseString2.reverseStr("abcdefg", 2));
    }
    public String reverseStr(String s, int k) {
        int idx = 0;
        StringBuilder sb = new StringBuilder(s);
        while (idx < s.length()) {
            int end = Math.min(idx + k, s.length());
            String reversed = reverse(s.substring(idx, end));
            sb.replace(idx, end, reversed);
            idx += 2 * k;
        }

        return sb.toString();
    }

    public String reverse(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = chars.length-1; i>= 0; i--) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}
