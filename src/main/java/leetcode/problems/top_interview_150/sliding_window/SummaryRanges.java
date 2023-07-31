package leetcode.problems.top_interview_150.sliding_window;

import java.util.LinkedList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new LinkedList();
        int n = nums.length;

        for (int i = 0; i < n; i++ ){

            int j = i;
            while (j < n-1 && nums[j+1] - 1 == nums[j]){
                j++;
            }

            String row = "" + nums[i];
            if (j == i) {
                res.add(row);
            } else {
                res.add(row + "->" + nums[j]);
            }
            i += (j-i);
        }


        return res;
    }
}
