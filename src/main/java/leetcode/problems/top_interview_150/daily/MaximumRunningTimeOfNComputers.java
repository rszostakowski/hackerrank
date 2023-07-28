package leetcode.problems.top_interview_150.daily;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class MaximumRunningTimeOfNComputers {


    //https://leetcode.com/problems/maximum-running-time-of-n-computers/description/
    public long maxRunTime(int n, int[] batteries) {

        int left = 0;
        int sum = Arrays.stream(batteries).sum();
        int right = sum;
        int mid = 0;

        Arrays.sort(batteries);
        System.out.println(right);
        while (left < right) {
            mid = (left + right) /2;
            if(isDoable(batteries, n, mid, sum)) {
                left = mid +1;
            } else {
                right = mid -1;
            }
        }

        return left;
    }

    private boolean isDoable(int[] batteries, int n, int mid, int sum) {
/*        int coverage =0;
        for (int i = 0; i < batteries.length; i++) {
            if (batteries[i] - mid > 0 ) {
                batteries[i] -= mid;
                coverage++;
            }
        }*/

        if (sum/mid >= n) {
            return true;
        }

        return false;
    }

    @Test
    public void test1() {
        Assert.assertEquals(maxRunTime(2, new int[]{3, 3, 3}), 4);
    }

    @Test
    public void test2() {
        Assert.assertEquals(maxRunTime(2, new int[]{1,1,1,1}), 2);
    }


}
