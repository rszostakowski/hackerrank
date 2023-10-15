package leetcode.problems.contests.biweekly_contest_115;

import java.util.LinkedList;
import java.util.List;

public class LastVisitedIntegers {
    public List<Integer> lastVisitedIntegers(List<String> words) {

        List<Integer> res = new LinkedList<>();

        int k = 0;
        List<Integer> integers = new LinkedList<>();
        for (String word : words) {
            if (word.matches("\\d+")) {
                int num = Integer.parseInt(word);
                integers.add(num);
                k = 0;
            } else {
                k++;
                if (k > integers.size()) {
                    res.add(-1);
                } else {
                    res.add(integers.get(integers.size()-k));
                }
            }
        }
        return res;
    }
}
