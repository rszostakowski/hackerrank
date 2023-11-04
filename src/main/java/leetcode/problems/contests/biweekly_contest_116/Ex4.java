package leetcode.problems.contests.biweekly_contest_116;

public class Ex4 {
    public static void main(String[] args) {
        Ex4 ex1 = new Ex4();
        int[] nums = {1, 2, 3};
        System.out.println(ex1.sumCounts(nums));
    }

    // this solution did not pass the test case
    public int sumCounts(int[] nums) {
        int n = nums.length;
        long sum = 0;

        int[] occurrence = new int[(int) 1e5 + 1];
        int uniqueCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int num = nums[j];
                if (occurrence[num] == 0) {
                    uniqueCount++;
                }
                occurrence[num]++;
                sum += ((long) uniqueCount * uniqueCount);
            }

            for (int j = i; j < n; j++) {
                int num = nums[j];
                occurrence[num] = 0;
            }
            uniqueCount = 0;
        }
        long mod = (long) (Math.pow(10, 9) + 7);
        return (int) (sum % mod);
    }
}
