package leetcode.problems.math;

public class PowerOfTwo {
    public boolean isPowerOfTwo(int x) {
        if (x < 0)
            return false;
        return x != 0 && ((x & (x - 1)) == 0);
    }
}
