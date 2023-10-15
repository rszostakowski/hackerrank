package leetcode.problems.contests.biweekly_contest_115;

import java.util.LinkedList;
import java.util.List;

public class LongestUnequalAdjacentGroupsSubsequence1 {

    //https://leetcode.com/contest/biweekly-contest-115/problems/longest-unequal-adjacent-groups-subsequence-i/
    public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        List<String> res = new LinkedList<>();
        List<Integer> uniqueGroups = new LinkedList<>();
        List<Integer> idxs = new LinkedList<>();

        if (n == 1) {
            res.add(words[0]);
            return res;
        }
        int prev = -1;
        for (int i = 1; i < n;i++) {
            if (prev != groups[i-1] && groups[i-1] != groups[i]) {
                uniqueGroups.add(groups[i-1]);
                idxs.add(i-1);
                uniqueGroups.add(groups[i]);
                idxs.add(i);
                prev = groups[i];
            } else if (prev != groups[i]){
                uniqueGroups.add(groups[i]);
                idxs.add(i);
                prev = groups[i];
            }
        }
        //System.out.println(uniqueGroups);
        //System.out.println(idxs);
        for (int i : idxs) {
            res.add(words[i]);
        }

        return res;
    }
}
