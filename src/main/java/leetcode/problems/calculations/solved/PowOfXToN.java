package leetcode.problems;

/*
https://leetcode.com/problems/powx-n/editorial/
 */
public class PowOfXToN {

    public double myPow(double x, int n) {
        return binaryExp(x, (long) n);
    }


    // my solution
    private double binaryExp(double x, long n) {
        System.out.println("x: " + x + " n: " +n);
        if (n == 0) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }
        double result = x;
        long nAbs = n < 0? -n:n;
        long squered = 1;

        while(true) {
            squered *= 2;
            if (squered > nAbs){
                break;
            }
            result *= result;
        }

        long diff = nAbs - squered /2 ;
        while(diff > 0) {
            result *= x;
            diff--;
        }

        if (n >= 1) {
            return result;
        } else if (n == 0) {
            return 1;
        } else {
            return (double) 1/result;
        }
    }

    // better solution from the editorial
    private double binaryExpFrom(double x, long n) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            n = -1 * n;
            x = 1.0 / x;
        }

        double result = 1;
        while (n != 0) {
            if (n % 2 == 1) {
                result = result * x;
                n -= 1;
            }
            x = x * x;
            n = n / 2;
        }
        return result;
    }
}
