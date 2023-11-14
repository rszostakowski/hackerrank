package leetcode.problems.strings;

import java.util.*;

public class SortVowelsInString {
    public static void main(String[] args) {
        sortVowels("jovcaBZuFNGORkENkQxlBESCGuvRYLxJCSZwHPpkHrTJwOwFSyMTOIVumkAAsfGgVHwWuAtrjcHgKDBdajYme");
    }
    static String VOWELS = "aeiouAEIOU";

    public static String sortVowels(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = chars[i];
            if(isInVowelsString(ch)){
                indices.add(i);
                map.put(ch, map.getOrDefault(ch, 0)+1);
            }
        }

        Set<Character> keySet = map.keySet();
        List<Character> keyList = new ArrayList<>(keySet);
        Collections.sort(keyList);

        Iterator<Integer> iterator = indices.iterator();

        for (Character key : keyList) {
            int counter = map.get(key);
            for (int i = 0; i < counter && iterator.hasNext(); i++) {
                int element = iterator.next();
                chars[element] = key;
                iterator.remove();
            }
        }

        return new String(chars);
    }

    static boolean  isInVowelsString(char c) {
        return VOWELS.indexOf(c) != -1;
    }
}
