package leetcode.problems.binary_search;

public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        //int[] nums = {11,13,15,17};
        //int[] nums = {4,5,6,7,0,1,2};
        int[] nums = {2,3,1};
        System.out.println(findMin(nums));
    }
    public static int findMin(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n -1 ;

        int count = 0;
        while (left <= right && count < 30) {
            if (nums[left] <= nums[right]) {
                return nums[left];
            }

            int mid = (left + right)/2;
            //System.out.println("mid idx: " + mid + " midVal: " + nums[mid]);
            if (nums[mid] >= nums[left]) {
                left = mid + 1;
            } else {
                right = mid;
            }
            count++;
        }

        return 0;
    }
}
