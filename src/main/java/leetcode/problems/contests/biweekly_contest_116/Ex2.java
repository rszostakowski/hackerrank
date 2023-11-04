package leetcode.problems.contests.biweekly_contest_116;

import java.util.HashSet;

public class Ex2 {
    public static void main(String[] args) {
        Ex2 ex1 = new Ex2();
        String str = "1001";
        //String str = "0000";
        //String str = "11000111";

        //System.out.println(isBeautiful(str));
        System.out.println(ex1.minChanges(str));
    }

    public int minChanges(String s) {

        int n = s.length();
        char[] chars = s.toCharArray();
        int counterSoFar =1;
        int changes = 0;
        for (int i = 1; i < n; i++) {
            if (chars[i-1] != chars[i]){
                if (counterSoFar % 2 == 1) {
                    changes++;
                    counterSoFar = 0;
                } else {
                    counterSoFar = 1;
                }
            } else {
                counterSoFar++;
            }
        }
        return changes;
    }

    static boolean isBeautiful(String s) {
        return s.length() % 2 == 0 && s.matches("^(.)\\1*$");
    }
}
