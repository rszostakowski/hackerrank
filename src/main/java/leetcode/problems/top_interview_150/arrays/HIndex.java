package leetcode.problems.top_interview_150.arrays;

import java.util.Arrays;

public class HIndex {

    public static void main(String[] args) {
        hIndex(new int[] {3,0,6,1,5});
    }
    // my solution
    public int hIndex2(int[] citations) {
        int n = citations.length;

        Arrays.sort(citations);
        int max = 0;
        for (int i = 0; i < n; i++) {
            int cited = citations[i];
            int howManyPaperWithAtLeast =  n - i;
            if (cited >= howManyPaperWithAtLeast) {
                max = Math.max(max, Math.min(cited, howManyPaperWithAtLeast));
            }
        }

        return max;
    }


    // interesting counting sort usage
    // https://leetcode.com/problems/h-index/solutions/70768/java-bucket-sort-o-n-solution-with-detail-explanation/
    public static int hIndex(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n+1];
        for(int c : citations) {
            if(c >= n) {
                buckets[n]++;
            } else {
                buckets[c]++;
            }
        }
        int count = 0;
        for(int i = n; i >= 0; i--) {
            count += buckets[i];
            if(count >= i) {
                return i;
            }
        }
        return 0;
    }
}
