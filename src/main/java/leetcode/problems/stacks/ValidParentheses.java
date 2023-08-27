package leetcode.problems.stacks;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack();

        for (char ch : s.toCharArray()) {
            if (ch ==  '(' || ch == '{' || ch == '[') {
                st.add(ch);
            } else {
                if (st.isEmpty()) {
                    return false;
                }
                Character last = st.pop();
                if (!((ch == ')' && last == '(') || (ch == '}' && last == '{') || (ch == ']' && last == '['))) {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}
