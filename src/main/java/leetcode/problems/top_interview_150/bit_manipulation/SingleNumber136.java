package leetcode.problems.top_interview_150.bit_manipulation;

public class SingleNumber136 {
    public int singleNumber(int[] nums) {
        int result = 0;

        for (int num : nums) {
            result ^= num;
        }

        return result;
    }
}
