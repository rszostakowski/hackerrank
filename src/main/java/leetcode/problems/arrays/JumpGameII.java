package leetcode.problems.arrays;

public class JumpGameII {

    public static void main(String[] args) {
        jump(new int[]{2,3,1,1,4});
    }
    // TODO to read https://leetcode.com/problems/jump-game-ii/solutions/1192401/easy-solutions-w-explanation-optimizations-from-brute-force-to-dp-to-greedy-bfs/
    // my solution
    public int jump2(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        int toReach = n-1;
        int maxJum = n-1;
        int jump = 1;

        while (true) {
            for (int i= toReach-1; i >=0; i--) {
                if (i + nums[i] >= toReach) {
                    if (i == 0) {
                        return jump;
                    }
                    maxJum = i;
                }
            };
            toReach = maxJum;
            jump++;
        }
    }

    // gready algorithm - brilliant solution I was trying to do it but I failed
    public static int jump(int[] A) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < A.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + A[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }
}
