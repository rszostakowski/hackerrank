package leetcode.problems.top_interview_150.math;

import java.math.BigInteger;

public class ReverseBits {
    public static void main(String[] args) {
        long sum = (long) 1000000000+ (long) 1000000000+ (long) 1000000000+ (long) 1000000000;
        System.out.println(sum);
        //System.out.println(reverseBits(4294967293));
    }

    public static int reverseBits(long n) {
        String binary = Long.toBinaryString(n);
        StringBuilder sb = new StringBuilder();
        sb.append(binary);

        String reversed = sb.reverse().toString();
        System.out.println("Input: " + binary);
        System.out.println("Output: " + reversed);

        return new BigInteger(reversed, 2).intValue();
    }
}
