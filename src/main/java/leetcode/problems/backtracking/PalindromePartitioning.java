package leetcode.problems.backtracking;

import java.util.*;
import java.util.stream.Collectors;

public class PalindromePartitioning {
    // aabb
    // results ->
    // "aabb",
    // "aa", "bb"
    // "a", "a", "bb"
    // "aa", "b", "b"
    // "a", "a", "b", "b"

    public static void main(String[] args) {
        PalindromePartitioning pp = new PalindromePartitioning();
        List<List<String>> aab = pp.partition("efe");
        System.out.println(aab);
    }
    public List<List<String>> partition(String s) {
        Set<List<String>> result = new HashSet<>();
        backtrack(s, result, new LinkedList(), 0);
        return new ArrayList<>(result);
    }

    private void backtrack(String s, Set<List<String>> result, List<String> subset, int index) {
        // if all elements palindroms
        if (index == s.length() && String.join("", subset).length() == s.length()) {
            result.add(new ArrayList<>(subset));
        }

        if (index >= s.length()){
            return;
        }

        for (int i = index; i < s.length(); i++) {
            char ch = s.charAt(i);
            subset.add("" + ch);
            System.out.println(subset);
            backtrack(s, result, subset, i + 1);
            subset.remove(subset.size() - 1);

            if (subset.size()>0) {
                String previous = subset.get(subset.size()-1);
                if (isPalindrome(previous + ch)){
                    subset.remove(subset.size() - 1);
                    subset.add(previous + ch);
                    System.out.println(subset);
                    backtrack(s, result, subset, i + 1);
                }
            }
        }
    }

    private boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }
        int left = 0;
        int right = s.length() -1;
        char[] chars = s.toCharArray();
        while (left < right) {
            if (chars[left] != chars[right])
                return false;
            left++;
            right--;
        }
        return true;
    }
}
