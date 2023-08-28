package leetcode.problems.binary_search;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n -1 ;

        int count = 0;
        while (left <= right && count < 30) {
            int mid = (left + right)/2;

            //System.out.println("mid idx: " + mid + " midVal: " + nums[mid]);
            if (nums[mid] == target) {
                return mid;
            }

            if(nums[left]<=nums[mid]){
                if(target > nums[mid] || target < nums[left]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }else{
                if(target < nums[mid] || target > nums [right]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            count++;
        }

        return -1;
    }
}
