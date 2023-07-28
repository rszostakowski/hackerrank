package leetcode.problems.top_interview_150.arrays;

import javax.xml.stream.events.Characters;

public class LengthOfLastWord150 {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        String[] divided = s.split(" ");
        String lastWord = divided[divided.length-1];
        return lastWord.length();
    }
}
