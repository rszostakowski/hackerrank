package leetcode.problems.top_interview_150.intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class MinimumNumberOfArrowsToBurstBalloons {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt((int[] row) -> row[0]));

        Stack<int[]> st = new Stack();
        int n = points.length;
        if (n != 0) {
            st.push(points[0]);

            for (int i =1; i < n; i++) {
                int[] last = st.pop();
                int[] current = points[i];

                if (last[1] >= current[0]){
                    int[] overllaping = {
                            Math.max(last[0], current[0]),
                            Math.min(last[1], current[1]),
                    };
                    st.push(overllaping);
                } else {
                    st.push(last);
                    st.push(current);
                }
            }
            return st.size();
        }

        return 0;
    }

    // Best solution from the editorial: https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/solutions/93703/share-my-explained-greedy-solution/
    public int findMinArrowShotsBest(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        int arrowPos = points[0][1];
        int arrowCnt = 1;
        for (int i = 1; i < points.length; i++) {
            if (arrowPos >= points[i][0]) {
                continue;
            }
            arrowCnt++;
            arrowPos = points[i][1];
        }
        return arrowCnt;
    }
}
