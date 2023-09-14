package leetcode.problems.arrays;

import java.util.Arrays;

public class Candy {

    // sprobowac cos takiego od lewej do prawej, ale co jak jak mamy doline na srodku?
    // it is a stupid idea
    // todo find the lowest spot
    public int candy2(int[] nums) {

        int n = nums.length;
        if (n == 1) {
            return 0;
        }

        int[] upsAndDown = new int[n];

        int left = 1;
        int right = n-2;

        while(left < right) {

            int leftVal = nums[left];
            int leftP1 = nums[left+1];
            if (left == leftP1) {
                upsAndDown[left++] = 1;
            } else if (left < leftP1) {
                upsAndDown[left] = upsAndDown[left-1];

            }

        }


        System.out.println(Arrays.toString(upsAndDown));

        return 0;
    }


    public int candy(int[] nums) {

        int n = nums.length;
        if (n == 1) {
            return 0;
        }

        int[] upsAndDown = new int[n];

        // first element
        if (nums[0] <= nums[1]) {
            upsAndDown[0] = 0;
        } else {
            upsAndDown[0] = 1;
        }
        int counter = upsAndDown[0];
        for (int i = 1; i < n-1; i++) {
            int val = nums[i];
            if (nums[i-1] < val) {
                upsAndDown[i] = upsAndDown[i-1] + 1;
            } else if(nums[i-1] == val) {
                upsAndDown[i] = upsAndDown[i-1];
            }
            else {
                upsAndDown[i] = upsAndDown[i-1]-1;
            }
            counter += upsAndDown[i];
        }

        // last element
        if (nums[n-2] > nums[n-1]) {
            upsAndDown[n-1] = upsAndDown[n-2]-1;
        } else if (nums[n-2] == nums[n-1]){
            upsAndDown[n-1] = upsAndDown[n-2];
        } else {
            upsAndDown[n-1] = upsAndDown[n-2] + 1;
        }
        counter += upsAndDown[n-1];




        System.out.println(Arrays.toString(upsAndDown));

        return counter;
    }

}
