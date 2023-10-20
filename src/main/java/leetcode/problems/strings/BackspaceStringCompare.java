package leetcode.problems.strings;

import java.util.Arrays;
import java.util.Stack;

public class BackspaceStringCompare {
    public static void main(String[] args) {
        //backspaceCompare("ab##", "c#d#");
        backspaceCompare("xywrrmp", "xywrrmu#p");
    }
    public static boolean backspaceCompare(String s, String t) {
        int sN = s.length();
        int tN = t.length();

        if (sN != tN)
            return false;

        Stack<Character> sStack = remove(s.toCharArray());
        Stack<Character> tStack = remove(t.toCharArray());

        System.out.println(sStack);
        System.out.println(tStack);

        return sStack.equals(tStack);
    }

    private static Stack<Character> remove(char[] sChars) {
        Stack<Character> st = new Stack<Character>();
        for (int i = 0; i <sChars.length; i++) {
            char ch = sChars[i];
            if (ch != '#') {
                st.add(ch);
            } else {
                st.pop();
            }
        }
        return st;
    }
}
