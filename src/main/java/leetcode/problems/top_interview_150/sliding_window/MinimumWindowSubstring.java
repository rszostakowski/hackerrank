package leetcode.problems.top_interview_150.sliding_window;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));
    }
    public static String minWindow(String s, String t) {
        int nT = t.length();
        int sT = s.length();

        int[] chT = new int[52];
        for (int i = 0; i < nT; i++) {
            char charAt = t.charAt(i);
            int pos = getPosition(charAt);
            chT[pos]++;
        }

        int left = 0, right = 0;
        int[] chS = new int[52];

        int minLen = Integer.MAX_VALUE;
        String result ="";
        while(right <= sT) {
            if(AreArrsEqual(chS, chT)) {
                if (right-left < minLen) {
                    minLen = Math.min(minLen, right-left);
                    result = s.substring(left, right);
                }
                char charAt = s.charAt(left);
                int pos = getPosition(charAt);
                chS[pos]--;
                left++;
            } else {
                if (right < sT) {
                    char charAt = s.charAt(right);
                    int pos = getPosition(charAt);
                    chS[pos]++;
                }

                right++;
            }
        }
        return result;
    }

    private static int getPosition(char c) {
        if (c >= 'a' && c <= 'z') {
            return c - 'a';
        } else if (c >= 'A' && c <= 'Z') {
            return 26 + c - 'A';
        }
        throw new RuntimeException();
    }

    private static boolean AreArrsEqual(int[] chS, int[] chT) {
        for (int i = 0; i < 52; i++) {
            if (chS[i] - chT[i] < 0) {
                return false;
            }
        }
        return true;
    }
}
