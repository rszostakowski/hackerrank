package leetcode.problems.strings;

import java.util.Arrays;

public class ReverseWordsInString3 {

    public String reverseWords(String s) {
        String[] split = s.split(" ");
        System.out.println(Arrays.toString(split));
        String[] reversed = Arrays.stream(split).map(this::reverse).toArray(String[]::new);
        return String.join(" ", reversed);
    }

    public String reverse(String str) {
        StringBuilder nstr = new StringBuilder();
        for (int i=0; i<str.length(); i++)
        {
            char ch= str.charAt(i);
            nstr.insert(0, ch);
        }

        return nstr.toString();
    }
}
