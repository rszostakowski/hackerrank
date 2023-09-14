package leetcode.problems.arrays;

public class ReverseString {
    public void reverseString(char[] s) {
        int n = s.length;
        for (int i=0; i < n/2; i++) {
            char temp = s[n-i-1];
            s[n-i-1] = s[i];
            s[i] = temp;
        }
    }


    // divide and conquer
    /*
    The string is split into half. Each substring will be further divided.
     This process continues until the string can no longer be divided (length `<= 1`).
     The conquering process will take they previously split strings and concatenate
     them in reverse order.
     */
    public String reverseString(String s) {
        int length = s.length();
        if (length <= 1) return s;
        String leftStr = s.substring(0, length / 2);
        String rightStr = s.substring(length / 2, length);
        return reverseString(rightStr) + reverseString(leftStr);
    }
}
