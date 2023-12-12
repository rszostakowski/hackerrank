package leetcode.problems.math;

public class LargestOddNumberInString {
    public String largestOddNumber(String num) {
        char[] ch = num.toCharArray();

        int n = ch.length-1;

        while(n >= 0) {
            if (Character.getNumericValue(ch[n]) % 2 ==0) {
                return num.substring(0, n +1);
            }
            n--;
        }
        return "";
    }
}
