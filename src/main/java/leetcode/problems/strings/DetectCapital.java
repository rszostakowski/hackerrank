package leetcode.problems.strings;

public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        char[] chars = word.toCharArray();

        boolean firstUpper = Character.isUpperCase(chars[0]);
        if (firstUpper && chars.length > 1) {
            boolean secondUpper = Character.isUpperCase(chars[1]);
            for (int i = 2; i < chars.length; i++) {
                if (secondUpper != Character.isUpperCase(chars[i])) {
                    return false;
                }
            }
        } else {
            for (int i = 1; i < chars.length; i++) {
                if (Character.isUpperCase(chars[i])) {
                    return false;
                }
            }
        }

        return true;
    }
}
