package leetcode.problems.math;

public class ExcelSheetColumnNumber {

    public int titleToNumber(String columnTitle) {
        char[] chars = columnTitle.toUpperCase().toCharArray();
        int sum = 0;

        for (char ch: chars) {
            sum *= 26;
            sum += ch - 'A' + 1;

        }

        return sum;
    }
}
