package leetcode.problems.top_interview_150.arrays;

import java.util.Arrays;

public class LongestCommonPrefix114
{
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        int minLen = Arrays.stream(strs).map(el -> el.length()).min(Integer::compareTo).get();
        int idx = -1;
        for (int colIdx = 0; colIdx < minLen; colIdx++ ) {
            String prev = strs[0];
            for (int i = 1; i < strs.length; i++ ) {
                if (strs[i].charAt(colIdx)!= prev.charAt(colIdx)) {
                    return strs[0].substring(0, idx+1);
                } else {
                    prev = strs[i];
                }
            }
            idx = colIdx;
        }

        if (idx == -1)
            return "";
        else
            return strs[0].substring(0, idx+1);
    }

    // better solution from the comment sections

    public String longestCommonPrefix2(String[] strs) {
        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length-1];
        int idx = 0;
        while(idx < s1.length() && idx < s2.length()){
            if(s1.charAt(idx) == s2.charAt(idx)){
                idx++;
            } else {
                break;
            }
        }
        return s1.substring(0, idx);
    }
}
