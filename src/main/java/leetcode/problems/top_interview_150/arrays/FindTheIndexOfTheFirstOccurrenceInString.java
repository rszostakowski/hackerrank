package leetcode.problems.top_interview_150.arrays;

public class FindTheIndexOfTheFirstOccurrenceInString {

    public static int strStr(String haystack, String needle) {
        int hayN = haystack.length();
        int neeN = needle.length();

        if (hayN < neeN) {
            return -1;
        }
        for (int i = 0; i<= hayN - neeN; i++) {

            int j = 0;
            while (j < neeN) {
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    break;
                }
                j++;
            }
            if (j == neeN) {
                return i;
            }
        }

        return -1;
    }

    // that is obvious solution but not so fast
    public int strStr2(String haystack, String needle) {
        if(haystack.contains(needle)){
            return haystack.indexOf(needle);
        }
        return -1;
    }

    //sliding window can also by applied

    public static void main(String[] args) {
        strStr("a", "a");
    }
}
