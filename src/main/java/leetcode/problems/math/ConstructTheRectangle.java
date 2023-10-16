package leetcode.problems.math;

public class ConstructTheRectangle {
    public int[] constructRectangle(int area) {
        if (area == 1) {
            return new int[] {1,1};
        }
        int[] res = new int[2];
        int localMin = Integer.MAX_VALUE;
        for (int i = 1; i <= area / 2; i++) {
            if (area % i == 0) {
                //System.out.println("w: " + i + " l: " + area / i);
                int dist = Math.abs(i - area / i);
                if (dist < localMin) {
                    res = new int[]{area / i, i};
                    localMin = dist;
                }
            }
        }

        return res;
    }
}
