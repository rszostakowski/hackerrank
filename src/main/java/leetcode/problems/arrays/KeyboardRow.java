package leetcode.problems.arrays;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class KeyboardRow {

    public static void main(String[] args) {
        String[] words = {"Hello","Alaska","Dad","Peace"};
        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.findWords(words);
    }
    public String[] findWords(String[] words) {
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";

        Set<Character> charSet1 = new HashSet<>();
        Set<Character> charSet2 = new HashSet<>();
        Set<Character> charSet3 = new HashSet<>();

        for (char c : row1.toCharArray()) {
            charSet1.add(c);
        }
        for (char c : row2.toCharArray()) {
            charSet2.add(c);
        }
        for (char c : row3.toCharArray()) {
            charSet3.add(c);
        }

        List<String> res = new LinkedList<>();
        for (String word: words) {
            Set<Character> wordSet = new HashSet<>();

            for (char c : word.toCharArray()) {
                wordSet.add(Character.toLowerCase(c));
            }

            if (charSet1.containsAll(wordSet)) {
                res.add(word);
            } else if (charSet2.containsAll(wordSet)) {
                res.add(word);
            } else if (charSet3.containsAll(wordSet)) {
                res.add(word);
            }
        }

        return res.toArray(new String[res.size()]);
    }
}
