package leetcode.problems.arrays;

public class SumOfAbsoluteDifferencesInaSortedArray {
    public static void main(String[] args) {
        SumOfAbsoluteDifferencesInaSortedArray sumOfAbsoluteDifferencesInaSortedArray = new  SumOfAbsoluteDifferencesInaSortedArray();
        int[] nums = {2,3,3,3,3 ,4, 5,6};
        sumOfAbsoluteDifferencesInaSortedArray.getSumAbsoluteDifferences(nums);
    }
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] results = new int[n];

        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        for (int i = 0; i < n; i++) {
            int val = nums[i];
            int leftSum = i * val - (i > 0 ? prefixSum[i - 1] : 0);
            int rightSum = (prefixSum[n - 1] - prefixSum[i]) - (n - i - 1) * val;

            results[i] = leftSum + rightSum;
        }

        return results;
    }
}
