package leetcode.problems.arrays;

import java.lang.reflect.Array;
import java.util.*;

public class FindWordsThatCanBeFormedByCharacters {

    public int countCharacters(String[] words, String chars) {
        int sum = 0;

        char[] top = chars.toCharArray();
        Arrays.sort(top);
        for (String word: words) {
            char[] wordCh = word.toCharArray();
            Arrays.sort(wordCh);
            if(containsAllCharacters(top, wordCh)){
                sum += wordCh.length;
            }
        }

        return sum;
    }

    private static boolean containsAllCharacters(char[] top, char[] smaller) {
        int[] frequencyArray = new int[256]; // Assuming ASCII characters

        for (char ch : top) {
            frequencyArray[ch]++;
        }

        for (char ch : smaller) {
            if (frequencyArray[ch] == 0) {
                return false;
            }
            frequencyArray[ch]--;
        }

        return true;
    }
}
