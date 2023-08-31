package leetcode.problems.backtracking;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {

    public static void main(String[] args) {
        List<String> strings = letterCombinations("23");
        strings.forEach(System.out::println);
    }

    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return new LinkedList();

        Map<Integer, char[]> mappings = new HashMap();
        mappings.put(2, new char[] {'a', 'b', 'c'});
        mappings.put(3, new char[] {'d', 'e', 'f'});
        mappings.put(4, new char[] {'g', 'h', 'i'});
        mappings.put(5, new char[] {'j', 'k', 'l'});
        mappings.put(6, new char[] {'m', 'n', 'o'});
        mappings.put(7, new char[] {'p', 'q', 'r', 's'});
        mappings.put(8, new char[] {'t', 'u', 'v'});
        mappings.put(9, new char[] {'w', 'x', 'y', 'z'});

        char[] digitCh = digits.toCharArray();

        List<String> combinations = new LinkedList<>();
        combinations.add("");

        for (char digit : digitCh) {
            char[] chars = mappings.get(Character.getNumericValue(digit));
            int n = combinations.size();
            List<String> toRemove = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                String currentString = combinations.get(i);
                toRemove.add(currentString);
                for (int j = 0; j < chars.length; j++) {
                    combinations.add(currentString + chars[j]);
                }
            }
            combinations.removeAll(toRemove);
        }
        return combinations;
    }

    // recursive approach
    // similar to https://github.com/neetcode-gh/leetcode/blob/main/java/0017-letter-combinations-of-a-phone-number.java
    public List<String> letterCombinationsRec(String digits) {
        if (digits.length() == 0)
            return new LinkedList();

        Map<Character, char[]> mappings = new HashMap();
        mappings.put('2', new char[] {'a', 'b', 'c'});
        mappings.put('3', new char[] {'d', 'e', 'f'});
        mappings.put('4', new char[] {'g', 'h', 'i'});
        mappings.put('5', new char[] {'j', 'k', 'l'});
        mappings.put('6', new char[] {'m', 'n', 'o'});
        mappings.put('7', new char[] {'p', 'q', 'r', 's'});
        mappings.put('8', new char[] {'t', 'u', 'v'});
        mappings.put('9', new char[] {'w', 'x', 'y', 'z'});

        List<String> ret = new LinkedList<String>();
        combination("", digits, 0, mappings,  ret);
        return ret;
    }

    public void combination(String str,  String digits, int offset, Map<Character, char[]> mappings, List<String> ret) {
        if (digits.length() == str.length()) {
            ret.add(str);
            return;
        }

        char current = digits.toCharArray()[offset];
        char[] letters = mappings.get(current);

        for (char ch: letters) {
            combination(str + ch, digits, offset + 1, mappings,  ret);
        }
    }
}
