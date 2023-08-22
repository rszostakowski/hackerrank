package leetcode.problems.strings;

import java.util.HashSet;
import java.util.Set;

public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        System.out.println(repeatedSubstringPatternFromComments("aabaab"));
    }
    public boolean repeatedSubstringPattern(String s) {
        char[] chars = s.toCharArray();

        int n = s.length();
        for (int length = 1; length <= n/2; length++) {
            Set<String> subparts = new HashSet();
            int lastIdx  = 0;
            for (int i = 0; i <= n - length; i += length) {
                String subpart = s.substring(i, i + length);
                //System.out.println(subpart);
                subparts.add(subpart);
                lastIdx = i + length;
            }
            if (subparts.size() == 1 && lastIdx == n) {
                for (String subi: subparts) {
                    System.out.println(subi);
                }
                return true;
            }
        }

        return false;
    }

    // best solution
    /*
    First char of input string is first char of repeated substring
Last char of input string is last char of repeated substring
Let S1 = S + S (where S in input string)
Remove 1 and last char of S1. Let this be S2
If S exists in S2 then return true else false
Let i be index in S2 where S starts then repeated substring length i + 1 and repeated substring S[0: i+1]
     */
    public static boolean repeatedSubstringPatternFromComments(String str) {
        String s = str + str;
        String s2 = s.substring(1, s.length() - 1);
        return s2.contains(str);
    }
}
