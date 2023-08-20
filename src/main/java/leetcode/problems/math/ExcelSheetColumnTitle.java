package leetcode.problems.math;

public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();

        while(n>0){
            n--;
            char ch = (char)('A' + n % 26);
            result.insert(0, ch);
            n /= 26;
        }

        return result.toString();
    }
}
