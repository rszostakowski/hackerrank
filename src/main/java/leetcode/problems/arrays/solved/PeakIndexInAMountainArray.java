package leetcode.problems;

public class PeakIndexInAMountainArray {

    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int low = 0;
        int high = n;

        while (low <= high) {
            int mid = low  + ((high - low) / 2);
            if (isPeak(arr, mid)){
                return mid;
            } else if (arr[mid-1] < arr[mid]) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return 0;
    }

    private boolean isPeak(int[] arr, int mid) {
        int current =  arr[mid];
        if (arr[mid-1] < current && arr[mid+1] < current) {
            return true;
        }
        return false;
    }
}
