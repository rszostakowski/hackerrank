package leetcode.problems.contests.biweekly_contest_112;
import java.util.*;

public class CheckIfStringsCanBeMadeEqualWithOperations1 {

    public static void main(String[] args) {
        CheckIfStringsCanBeMadeEqualWithOperations1 ex1 = new CheckIfStringsCanBeMadeEqualWithOperations1();
        //ex1.canBeEqual("ppeb", "ebpp");
        //ex1.canBeEqual("xbcx", "cxxb");
        //ex1.canBeEqual("ffww", "wwff");
        //ex1.canBeEqual("ifjz", "jzfi");
        ex1.canBeEqual("abcd", "cdab");
        //"abcd" //"cdab"

    }
    public boolean canBeEqual(String s1, String s2) {

        char[] chars1 = s1.toCharArray();
        char[] chars2 = s1.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);

        if (Arrays.equals(chars1, chars2)){

            for (int i = 0; i <s1.length()-2; i++) {
                if (s2.charAt(i) == s1.charAt(i)) {
                    continue;
                }else {
                    if (s2.charAt(i) == s1.charAt(i+2) && s1.charAt(i) == s2.charAt(i+2)) {
                        s1 = swap(s1, i, i+2);
                    } else {
                        return false;
                    }

                }
            }
        }
        return s1.equals(s2);
    }

    private String swap(String s1, int i, int j) {
        char[] charArray = s1.toCharArray();
        if (i >= 0 && i < charArray.length && j >= 0 && j < charArray.length) {
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
        }
        return new String(charArray);
    }
}
