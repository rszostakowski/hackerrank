package leetcode.problems.top_interview_150.arrays;

import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {
        int [] nums1 = new int[] {1, 3, 0, 0, 0, 0};
        int [] nums2 = new int[] {1, 2, 5, 6};
        merge(nums1, 2, nums2, 4);
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        System.out.println(nums1);
    }

    //alternatrive
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        for (int j = 0, i = m; j < n; j++) {
            nums1[i] = nums2[j];
            i++;
        }
        Arrays.sort(nums1);
    }
}
