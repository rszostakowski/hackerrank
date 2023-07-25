package leetcode.problems.top_interview_150.arrays;

public class RomanToInteger13 {
    public int romanToInt(String s) {
        int prev = convert(s.charAt(0));
        int result = prev;
        for(int i = 1; i < s.length(); i++) {
            int current = convert(s.charAt(i));
            if (prev < current) {
                result -= 2* prev;
            }
            result += current;
            prev = current;
        }

        return result;
    }

    int convert(char c) {
        if (c == 'I') {
            return 1;
        }
        if (c == 'V') {
            return 5;
        }
        if (c == 'X') {
            return 10;
        }
        if (c == 'L') {
            return 50;
        }
        if (c == 'C') {
            return 100;
        }
        if (c == 'D') {
            return 500;
        }
        if (c == 'M') {
            return 1000;
        }
        return 0;
    }
}
