package leetcode.problems.top_interview_150.math;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int i = n - 1;

        int carry = 1;
        while (i >= 0 && carry == 1) {
            if (digits[i] + carry == 10){
                digits[i] = 0;
                carry = 1;
            } else {
                digits[i] += carry;
                carry = 0;
            }
            i--;
        }

        if (carry == 1) {
            int[] copiedArray = new int[n+1];
            System.arraycopy(digits, 0, copiedArray, 1, n);
            copiedArray[0] = 1;
            return copiedArray;
        }

        return digits;
    }
}
