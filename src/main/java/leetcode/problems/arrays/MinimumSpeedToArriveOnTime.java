package leetcode.problems.arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MinimumSpeedToArriveOnTime {
    public static int minSpeedOnTime(int[] dist, double hour) {
        int[] copied = Arrays.copyOf(dist, dist.length);
        int n = dist.length;

        if (n-1 > hour)
            return -1;

        double leftHours = hour - (n-1);

        List<Integer> sortedList = Arrays.stream(dist)
                .boxed()
                .sorted((f1, f2) -> Integer.compare(f2, f1))
                .collect(Collectors.toList());
        List<Integer> biggest = sortedList.stream()
                .limit((int) leftHours)
                .collect(Collectors.toList());

        if (biggest.size() == 0) {
            double spead = dist[n - 1] / leftHours;
            return Math.max((int) spead, sortedList.get(0));
        }
        int minSpead = (int) Math.ceil(biggest.get(biggest.size()-1) / hour);
        System.out.println(minSpead);

        int left = minSpead;
        int right = 10000000;

        int spreadToReturn = -1;
        while(left <= right) {
            int mid = (left + right) / 2;

            // Move to the left half.
            if (timeRequired(dist, n, mid) <= hour) {
                spreadToReturn = mid;
                right = mid - 1;
            } else {
                // Move to the right half.
                left = mid + 1;
            }
        }
        return spreadToReturn;
    }

    private static double timeRequired(int[] dist, int n, int speadToTest) {
        double time = 0;
        for (int i = 0; i< n -1; i++) {
            double partialTime = (float) dist[i] / speadToTest;
            time += Math.ceil(partialTime);
        }
        time += (float) dist[n -1]/ speadToTest;
        return time;
    }

    public static int minSpeedOnTime2(int[] dist, double hour) {
        int n = dist.length;

        if (n-1 > hour)
            return -1;

        double leftHours = hour - (n-1);

        long sumDists = Arrays.stream(dist).mapToLong(e->e).sum();
        System.out.println(sumDists);

        int minSpead = (int) Math.ceil(sumDists / hour);
        System.out.println(minSpead);
        while(true) {
            double time = timeRequired(dist, n, minSpead);

            if (time <= hour) {
                return minSpead;
            }
            minSpead++;
        }
    }
    @Test
    public void test() {
        //Assert.assertEquals(minSpeedOnTime(new int[]{1,3,2}, 2.7), 3);
        //Assert.assertEquals(minSpeedOnTime(new int[]{1,1,100000}, 2.01), 10000000);
        Assert.assertEquals(minSpeedOnTime(new int[]{5,3,4,6,2,2,7}, 10.92), 4);
       // Assert.assertEquals(minSpeedOnTime(new int[]{5,3,4,6,2,2,7}, 10.92), 4);
    }
}
