package leetcode.problems.arrays;

//https://leetcode.com/problems/sort-array-by-parity/?envType=daily-question&envId=2023-09-28
public class SortArrayByParity {

    public static void main(String[] args) {
        int[] nums = {3,1,2,4};
        sortArrayByParityBest(nums);
    }
    // my solution
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int[] sorted = new int[n];

        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2  == 0) {
                sorted[idx++] = nums[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2  != 0) {
                sorted[idx++] = nums[i];
            }
        }

        return sorted;
    }

    // the best solution
    public static int[] sortArrayByParityBest(int[] A) {
        for (int i = 0, j = 0; j < A.length; j++)
            if (A[j] % 2 == 0) {
                int tmp = A[i];
                A[i++] = A[j];
                A[j] = tmp;;
            }
        return A;
    }
}
