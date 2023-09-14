package leetcode.problems.math;

public class PowerOfThree
{
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }

        while(n % 3 == 0) {
            n = n/3;
        }

        System.out.println(n);
        return n == 1;
    }

    // all methods here https://leetcode.com/problems/power-of-three/solutions/77876/a-summary-of-all-solutions-new-method-included-at-15-30pm-jan-8th/

    public boolean isPowerOfThree_best(int n) {
        // 1162261467 is 3^19,  3^20 is bigger than int
        return ( n>0 &&  1162261467%n==0);
    }
}
