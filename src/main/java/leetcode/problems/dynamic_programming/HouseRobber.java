package leetcode.problems.dynamic_programming;

public class HouseRobber {
// [1,2,3,1]
// [1, 2, 4, 3]

//[2,7,9,3,1]
//[2,7,11,10,12]

// [2,1,1,2]
// [2,1,3,4]

//[2,1,1,10,1,1,2]
//[2,1,3,12,]
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] db = new int[n];

        int msf = nums[0];
        db[0] = nums[0];
        db[1] = nums[1];

        for (int i = 2; i < nums.length; i++) {
            db[i] = Math.max(msf+nums[i], db[i-2] + nums[i]);
            msf = Math.max(msf, db[i-2]);
        }

        return Math.max(msf, Math.max(db[n-2], db[n-1]));
    }
}
