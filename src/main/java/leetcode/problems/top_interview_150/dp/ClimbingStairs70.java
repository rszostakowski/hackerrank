package leetcode.problems.top_interview_150.dp;

public class ClimbingStairs70 {
    public static void main(String[] args) {
        System.out.println(climbStairs(1));
    }
    public static int climbStairs(int n) {
        int arrN = Math.max(3, n+1);
        int[] cached = new int[arrN];
        cached[0] = 0;
        cached[1] = 1;
        cached[2] = 2;
        return climbStairs(cached, n);
    }

    public static int climbStairs(int[] cached, int n) {

        if (cached[n] != 0) {
            return cached[n];
        }

        int result = climbStairs(cached, n - 1) + climbStairs(cached, n - 2);
        cached[n] = result;
        return result;
    }
}
