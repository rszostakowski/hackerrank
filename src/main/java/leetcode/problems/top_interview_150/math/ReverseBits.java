package leetcode.problems.top_interview_150.math;

import java.math.BigInteger;

public class ReverseBits {
    public int reverseBits(int n) {
        String binary = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder();
        sb.append(binary);

        String reversed = sb.reverse().toString();
        System.out.println("Input: " + binary);
        System.out.println("Output: " + reversed);

        return Integer.parseInt(reversed, 2);
    }
}
