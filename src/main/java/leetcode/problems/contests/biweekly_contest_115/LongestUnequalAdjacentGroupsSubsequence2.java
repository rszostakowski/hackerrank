package leetcode.problems.contests.biweekly_contest_115;

import leetcode.problems.dynamic_programming.ClimbingStairs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LongestUnequalAdjacentGroupsSubsequence2 {

    // not finished, some tests are failing
    // https://leetcode.com/contest/biweekly-contest-115/problems/longest-unequal-adjacent-groups-subsequence-ii/

    public static void main(String[] args) {
        LongestUnequalAdjacentGroupsSubsequence2 cl = new LongestUnequalAdjacentGroupsSubsequence2();
/*
        String[] words = {"bdb","aaa","ada"};
        int[] groups= {2,1,3};
        System.out.println(cl.getWordsInLongestSubsequence2(groups.length, words, groups));*/

//        String[] words = {"bab","bdd","bca","dab"};
//        int[] groups= {2,4,1,2};
//        System.out.println(cl.getWordsInLongestSubsequence2(groups.length, words, groups));
        //["dab"]


/*        String[] words = {"ba","ee","ed","ddddd","ce"};
        int[] groups= {4,4,4,5,5};
        System.out.println(cl.getWordsInLongestSubsequence2(groups.length, words, groups));*/

        String[] words = {"acc","ab","baa","dac","aa"};
        int[] groups= {3,1,2,3,3};
        System.out.println(cl.getWordsInLongestSubsequence2(groups.length, words, groups));
        //Expected:["ee","ce"]
    }

    public List<String> getWordsInLongestSubsequence2(int n, String[] words, int[] groups) {
        List<String> res = new LinkedList<>();
        List<Integer> uniqueGroups = new LinkedList<>();
        // List<Integer> idxs = new LinkedList<>();

        if (n == 1) {
            res.add(words[0]);
            return res;
        }
        int prev = -1;
        for (int i = 1; i < n;i++) {
            if (prev != groups[i-1] && groups[i-1] != groups[i]) {
                uniqueGroups.add(groups[i-1]);
                //idxs.add(i-1);
                uniqueGroups.add(groups[i]);
                //idxs.add(i);
                prev = groups[i];
            } else if (prev != groups[i]){
                uniqueGroups.add(groups[i]);
                //idxs.add(i);
                prev = groups[i];
            }
        }

        System.out.println(uniqueGroups);

        Map<Integer, List<String>> groupsToString = new HashMap();
        for (int i = 0; i < n; i++) {
            List<String> list = groupsToString.getOrDefault(groups[i], new LinkedList<>());
            list.add(words[i]);
            groupsToString.put(groups[i], list);
        }

        LinkedList<String> finalList = new LinkedList<>();
        for (int starting = 0; starting < uniqueGroups.size(); starting++) {
            Integer startIdx = uniqueGroups.get(starting);
            List<String> startList = groupsToString.getOrDefault(startIdx, new LinkedList<>());

            for (String startWord: startList) {
                res = new LinkedList<>();
                List<Integer> groupsIdx = new LinkedList<>();

                res.add(startWord);
                groupsIdx.add(startIdx);

                for (int i = starting +1; i < uniqueGroups.size(); i ++) {
                    Integer idx = uniqueGroups.get(i);
                    List<String> list = groupsToString.getOrDefault(idx, new LinkedList<>());
                    for (String word: list) {
                        String lastAddedString = res.get(res.size() - 1);
                        int lastIdx = groupsIdx.get(groupsIdx.size()-1);
                        if (word.length() == lastAddedString.length() && lastIdx != idx && hammingDistance(word, lastAddedString)== 1){
                            res.add(word);
                            break;
                        }
                    }
                }

                if (res.size() >= finalList.size()) {
                    finalList  = new LinkedList<>(res);
                }
            }
        }
        return finalList;
    }

    public static int hammingDistance(String str1, String str2) {
        int distance = 0;
        // Iterate through the characters of both strings and compare them
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                distance++;
            }
        }

        return distance;
    }
}
