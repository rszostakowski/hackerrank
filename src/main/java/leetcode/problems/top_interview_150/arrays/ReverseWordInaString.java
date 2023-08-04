package leetcode.problems.top_interview_150.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseWordInaString {

    public String reverseWords(String s) {
        String[] split = Arrays.stream(s.split(" "))
                .map(str -> str.trim())
                .filter(str -> str.length()>0)
                .toArray(String[]::new);

        int n = split.length;
        for (int i = 0; i < n/2; i++) {
            String temp = split[i];
            split[i] = split[n-i-1];
            split[n-i-1] = temp;
        }

        return String.join(" ", split);
    }
}
