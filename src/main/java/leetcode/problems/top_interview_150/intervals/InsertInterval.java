package leetcode.problems.top_interview_150.intervals;

import java.util.*;

public class InsertInterval {
    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        inserMy(intervals, newInterval);
    }
    public static  int[][] inserMy(int[][] intervals, int[] newInterval) {
        int n = intervals.length;

        int[][] newArray = new int[n + 1][2];

        System.arraycopy(intervals, 0, newArray, 0, intervals.length);

        newArray[newArray.length - 1] = newInterval;

        Arrays.sort(newArray, Comparator.comparingInt((int[] row) -> row[0]).thenComparing(row -> row[1]));

        Stack<int[]> st = new Stack();

        st.push(newArray[0]);

        for (int i=1; i < newArray.length; i++) {
            int[] last = st.pop();

            int left = newArray[i][0];
            if (last[1] >= left) {
                int right = newArray[i][1];
                if (last[1] < right) {
                    last[1] = right;
                }
                st.push(last);
            } else {
                st.push(last);
                st.push(newArray[i]);
            }


        }

        return st.toArray(new int[st.size()][]);
    }

    // the most beatiful solution
    public int[][] insertTheBest(int[][] intervals, int[] newInterval) {
        List<int[]> result = new LinkedList<>();
        int i = 0;
        int n = intervals.length;

        while (i <n && intervals[i][1] < newInterval[0] ) {
            result.add(intervals[i]);
            i++;
        }

        int start = newInterval[0];
        int end = newInterval[1];

        while (i <n && intervals[i][0] <= newInterval[1]) {
            start= Math.min(intervals[i][0], start);
            end= Math.max(intervals[i][1], end);
            i++;
        }
        result.add(new int[]{start, end});

        while(i <n) {
            result.add(intervals[i]);
            i++;
        }
        return result.toArray(new int[result.size()][]);
    }


    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new LinkedList<>();
        int i = 0;
        // add all the intervals ending before newInterval starts
        while (i < intervals.size() && intervals.get(i).end < newInterval.start)
            result.add(intervals.get(i++));
        // merge all overlapping intervals to one considering newInterval
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval = new Interval( // we could mutate newInterval here also
                    Math.min(newInterval.start, intervals.get(i).start),
                    Math.max(newInterval.end, intervals.get(i).end));
            i++;
        }
        result.add(newInterval); // add the union of intervals we got
        // add all the rest
        while (i < intervals.size()) result.add(intervals.get(i++));
        return result;
    }


    // almost done, very ugly
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> listOfArrays = new ArrayList<>();
        listOfArrays.add(new int[]{1, 2, 3});
        listOfArrays.add(new int[]{4, 5, 6});

        int n = intervals.length;
        int[] first = null;
        int firstIdx = 0;

        int[] second = null;
        int secondIdx = 0;

        for (int i=0; i< intervals.length; i++) {
            int[] current = intervals[i];

            // first entry
            if (current[1] >= newInterval[0] && newInterval[0] >= current[0]){
                first = current;
                firstIdx = i;
            } else if (current[0] <= newInterval[1] && current[1] >= newInterval[1]){
                second = current;
                secondIdx = i;
            }
        }

        System.out.println("first: " + Arrays.toString(first));
        System.out.println("second: " + Arrays.toString(second));

        if (first != null && second != null) {
            int resN = firstIdx + (n-secondIdx);
            int k = 0;
            int[][] res = new int[resN][2];

            for (int i=0; i< firstIdx; i++) {
                res[k++] = intervals[i];
            }
            int[] merged = {first[0], second[1]};
            res[k++] = merged;

            for (int i=secondIdx+1; i< n; i++) {
                res[k++] = intervals[i];
            }

            return res;
        } else if(first !=null) {

            if (first[1] < newInterval[1]) {
                int[] merged = {first[0], newInterval[1]};
                intervals[firstIdx] = merged;
            }
            return intervals;
        }


        int[][] newArray = new int[n + 1][2];

        System.arraycopy(intervals, 0, newArray, 0, intervals.length);

        newArray[newArray.length - 1] = newInterval;

        return newArray;
    }

    class Interval{

        public double end;
        public double start;

        public Interval(double min, double max) {

        }
    }
}
