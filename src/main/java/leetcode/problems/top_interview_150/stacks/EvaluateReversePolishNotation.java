package leetcode.problems.top_interview_150.stacks;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvaluateReversePolishNotation {

    public static void main(String[] args) {
        String[] tokens = new String[] {"4","13","5","/","+"};
        evalRPN(tokens);
    }
    public static int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack();
        Set<String> operations = new HashSet();
        operations.add("+");
        operations.add("-");
        operations.add("/");
        operations.add("*");

        for (int i = 0; i< tokens.length; i++) {
            String sign = tokens[i];

            if(operations.contains(sign)) {
                 int first = st.pop();
                int second = st.pop();
                if (sign.equals("+")) {
                    st.push(first + second);
                } else if (sign.equals("-")) {
                    st.push(second - first);
                } else if (sign.equals("/")) {
                    st.push(second / first);
                } else if (sign.equals("*")) {
                    st.push(first * second);
                }
            } else{
                st.push(Integer.parseInt(sign));
            }
        }

        return st.pop();
    }
}
