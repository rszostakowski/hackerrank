package leetcode.problems.math;

import java.math.BigInteger;

public class DivideTwoIntegers {
/*    public int divide(int dividend, int divisor) {
        boolean isBelowZero = true;
        if ((dividend > 0 && divisor > 0)
            || (dividend < 0 && divisor < 0)) {
        isBelowZero = false;
        }

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
        System.out.println("MIN_VALUE");
        return Integer.MIN_VALUE -1;
        }

        if (divisor == 1) {
        System.out.println("Returning 1");
        return dividend;
        }

        if (divisor == -1) {
        System.out.println("Returning -1");
        return -dividend;
    }

    BigInteger bigDividend = Math.abs(BigInteger.valueOf(dividend));
    BigInteger bigDivisor = Math.abs(BigInteger.valueOf(divisor));

    int counter = 0;
        while (bigDividend >= bigDivisor) {
        bigDividend -= bigDivisor;
        counter++;
    }

        System.out.println("counter is: "+ counter);
        if (isBelowZero) {
        return -counter;
    }
        return counter;*/
}
