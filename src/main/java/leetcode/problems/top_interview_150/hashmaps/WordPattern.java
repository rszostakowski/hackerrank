package leetcode.problems.top_interview_150.hashmaps;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    public static void main(String[] args) {
        wordPattern("abba" , "dog cat cat fish");
    }

    // great explanation of the problem https://leetcode.com/problems/word-pattern/solutions/73402/8-lines-simple-java/

    public static boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();
        for (Integer i=0; i<words.length; ++i)
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;
        return true;
    }

    // my solution
    public static boolean wordPattern2(String pattern, String s) {
        Map<Character, String> chToPa = new HashMap();

        String[] split = s.split(" ");

        if (split.length != pattern.length()) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            Character ch = pattern.charAt(i);
            String sub = split[i];
            System.out.println("ch: " + ch + " sub: "+ sub);
            if (chToPa.containsKey(ch) && chToPa.get(ch).equals(sub)) {
                continue;
            } else if ((chToPa.containsKey(ch) && !chToPa.get(ch).equals(sub)) || chToPa.containsValue(sub)) {
                return false;
            }
            else {
                chToPa.put(ch, sub);
            }
        }

        return true;
    }
}
