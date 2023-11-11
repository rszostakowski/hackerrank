package leetcode.problems.dynamic_programming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DecodeWays {

    public static void main(String[] args) {
        DecodeWays decodeWays = new DecodeWays();
        decodeWays.numDecodings("1123"); // 5
        // 11 23
        // 1 1  23
        // 1 1 2 3
        // 11 2 3
        // 1 12 3


        //decodeWays.numDecodings("10");
//        decodeWays.numDecodings("11106");
//        decodeWays.numDecodings("12"); //2
//        decodeWays.numDecodings("226"); //3
//        decodeWays.numDecodings("06"); //0
    }
//"2011106
// 2021111
    //2101
    //1101

    //"11106" can be mapped into:
    // 21111
    //"AAJF" with the grouping (1 1 10 6)
    //"KJF" with the grouping (11 10 6)
    public int numDecodingsw(String s) {
        char[] chars = s.toCharArray();
        Set set = Set.of('1', '2', '3', '4', '5', '6');
        Set<Character> gr = new HashSet<>();
        if (chars.length == 2 && chars[0] == '0') {
            return 0;
        }

        int n = chars.length;
        int[] dp = new int[chars.length];

        for (int i = n-1; i >= 0; i--) {
            if (chars[i] != '0' && i == n - 1) {
                dp[i] = 1;
            } else if (chars[i] == '0') {
                dp[i] = 0;
            } else if (chars[i + 1] == '0' && (chars[i] == '1' || chars[i] == '2')){
                if (i+2 <= n-1)
                    dp[i] = dp[i+2];
                else
                    dp[i] = 1;
            } else if (chars[i] != '0'){
                dp[i] = dp[i+1];
                if (set.contains(chars[i + 1]) && (chars[i] == '1' || chars[i] == '2') && (i+2 > n-1 || chars[i+2] != '0')) {
                    dp[i]++;
                }
            }
            else {
                return 0;
            }
        }
        System.out.println(Arrays.toString(dp));

        return dp[0];
    }
    Set set = Set.of('1', '2', '3', '4', '5', '6');
    public int numDecodings(String s) {
        int n = s.length();
        if (s.charAt(0) == '0') {
            return 0;
        }
        return 1 + numDecodings(s.substring(1, n), s.charAt(0));
    }

    //2101
    //11106 -> 2
    public int numDecodings(String s, Character prev) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        if (n > 1) {
            char ch = s.charAt(0);
            // TODO TBD
        }

        return 0;
    }
}
