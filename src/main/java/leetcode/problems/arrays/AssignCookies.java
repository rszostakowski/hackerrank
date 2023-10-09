package leetcode.problems.arrays;

import java.util.Arrays;

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int gIdx=0;

        int res = 0;
        for (int sIdx =0; sIdx < s.length; sIdx++){
            if (gIdx >= g.length) {
                break;
            }
            if(g[gIdx] <= s[sIdx]) {
                res++;
                gIdx++;
            }
        }

        return res;
    }
}
