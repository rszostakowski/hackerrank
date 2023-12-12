package leetcode.problems.contests.biweekly_contest_119;

public class Ex2 {
    public static void main(String[] args) {
        Ex2 ex = new Ex2();
        if (ex.removeAlmostEqualCharacters("ba") != 1) {
            throw new RuntimeException("7");
        };

        if (ex.removeAlmostEqualCharacters("aaaaa") != 2) {
            throw new RuntimeException("1");
        };
        if (ex.removeAlmostEqualCharacters("abddez") != 2) {
            throw new RuntimeException("2");
        };
        if (ex.removeAlmostEqualCharacters("zyxyxyz") != 3) {
            throw new RuntimeException("3");
        };
        if (ex.removeAlmostEqualCharacters("ab") != 1) {
            throw new RuntimeException("4");
        };
        if (ex.removeAlmostEqualCharacters("a") != 0) {
            throw new RuntimeException("5");
        };
        if (ex.removeAlmostEqualCharacters("") != 0) {
            throw new RuntimeException("6");
        };

    }

    public int removeAlmostEqualCharacters(String word) {
        char[] chars = word.toCharArray();
        int counter = -0;
        for (int i = 1; i < chars.length; i++) {
            if(chars[i-1] == chars[i] || chars[i-1] +1 == chars[i] || chars[i-1] -1 == chars[i]) {
                System.out.println("almostequals");
                chars[i] = 'A';
                counter++;
            }
        }
        return counter;
//        char[] alphabetArray = new char[26];
//
//        for (int i = 0; i < 26; i++) {
//            alphabetArray[i] = (char) ('a' + i);
//        }
    }
}
