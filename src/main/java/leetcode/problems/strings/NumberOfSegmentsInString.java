package leetcode.problems.strings;

public class NumberOfSegmentsInString {
    public int countSegments(String s) {
        if (s.length() == 0) {
            return 0;
        }
        String[] split = s.split(" ");

        int counter = 0;

        for (String partial: split) {
            if (partial.length() != 0) {
                counter++;
            }
        }
        return counter;
    }
}
