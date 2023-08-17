package leetcode.problems.arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length;

        int boundStart = -1;
        int boundEnd = -1;
        int idx = -1;

        if (nums.length >0) {
            for (int i = 0; i < 10; i++) {
                idx = (start + end)/2;
                //System.out.println("idx is: " + idx);
                if (nums[idx] == target){
                    boundStart = idx;
                    boundEnd = idx;
                    break;
                } else if (nums[idx] < target) {
                    start = idx;
                } else{
                    end  = idx;
                }
            }
        }

        for (int j = boundStart-1; j >= 0; j--) {
            if (nums[j] == target) {
                boundStart = j;
            } else {
                break;
            }
        }

        for (int k = boundEnd+1; k <= nums.length-1; k++) {
            if (nums[k] == target) {
                boundEnd = k;
            } else {
                break;
            }
        }

        return new int[] {boundStart, boundEnd};
    }

    // the best solution form the internet
    public int[] searchRangeBest(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }

    private int findFirst(int[] nums, int target){
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] >= target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
            if(nums[mid] == target) idx = mid;
        }
        return idx;
    }

    private int findLast(int[] nums, int target){
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] <= target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
            if(nums[mid] == target) idx = mid;
        }
        return idx;
    }
}
