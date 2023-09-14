package leetcode.problems.arrays;

public class RangeSumQueryImmutable {
    int[] nums;
    public RangeSumQueryImmutable(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        for (int i = left; i <=right; i++) {
            sum += nums[i];
        }
        return sum;
    }

    // the best solution
    /*
    public RangeSumQueryImmutable(int[] nums) {
        for(int i = 1; i < nums.length; i++)
            nums[i] += nums[i - 1];
        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        if(left == 0)
            return nums[right];

        return nums[right] - nums[left - 1];
    }
    */
}
