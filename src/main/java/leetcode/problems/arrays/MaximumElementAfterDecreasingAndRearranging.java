package leetcode.problems.arrays;

import java.util.Arrays;
import java.util.OptionalInt;

public class MaximumElementAfterDecreasingAndRearranging {
    public static void main(String[] args) {
        //int[] arr = {1,2,2,2,2,2,2,4,6,10};
        int[] arr = {2,2,1,2,1};
        //int[] arr = {73,98,9};
        //int[] arr = {9,9,9,9,9,9,9,9,9,9,9,9,21};
        int res = maximumElementAfterDecrementingAndRearranging(arr);
        System.out.println(res);
    }
    public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;
        int n = arr.length;
        for(int i = 1; i < n;i++) {
            if (Math.abs(arr[i]-arr[i-1]) > 1) {
                arr[i] = arr[i-1] + 1;
            }
        }
        return arr[n-1];
    }
}
