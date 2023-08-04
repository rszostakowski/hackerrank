package leetcode.problems.top_interview_150.arrays;

import java.util.LinkedList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length;
        List<String> res = new LinkedList<String>();

        String row = "";
        for (int i = 0; i <n; i++) {
            if (words[i].length()+1 <= 16 - row.length()) {
                row += words[i];
                row += " ";
            } else {
                while (row.length() < 16) {
                    row += " ";
                }
                res.add(row);
                row = "";
                i--;
            }
        }

        return res;
    }
}
