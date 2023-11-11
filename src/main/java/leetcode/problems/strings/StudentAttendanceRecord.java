package leetcode.problems.strings;

public class StudentAttendanceRecord {
    public boolean checkRecord(String s) {
        char[] chars = s.toCharArray();

        boolean hasA = false;
        int counter = 0;
        for (char ch: chars) {
            if (ch == 'A' ){
                if (hasA == false) {
                    hasA = true;
                } else {
                    return false;
                }
                counter = 0;
            } else if (ch == 'L') {
                counter++;
                if (counter ==3) {
                    return false;
                }
            }else {
                counter = 0;
            }
        }
        return true;
    }
}
