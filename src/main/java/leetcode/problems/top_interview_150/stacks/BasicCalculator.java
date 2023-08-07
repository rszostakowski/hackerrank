package leetcode.problems.top_interview_150.stacks;

import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {

        char[] chars = s.toCharArray();

        char prev = ' ';
        boolean reverseSign = false;
        int result = 0;
        int n = s.length();

        Stack<Character> st = new Stack();
        for (int i = 0; i<n; i++) {
            char ch = chars[i];
            if (ch == ')'){
                do {
                    int first = Character.getNumericValue(st.pop());
                    char operand =  st.pop();
                    if (Character.isDigit(st.peek())) {
                        st.push(operand);
                        st.push((char) first);
                    } else {
                        int second = Character.getNumericValue(st.pop());
                        if (operand == '+') {
                          //  st.push((char) first + second);
                        } else if (operand == '-') {
                          //  st.push((char) second - first);
                        }

                    }
                } while (st.peek() == '(');


                // check if - before ();
            } else {
                st.push(ch);
            }
        }


        return result;
    }

    public int calc(String s) {
        char[] chars = s.toCharArray();
        int n = s.length();
        char prev = ' ';
        int result = 0;
        for (int i = 0; i < n; i++) {
            char ch = chars[i];
            if (ch == ' ')
                continue;
            if (Character.isDigit(ch)){
                String val = "" + ch;
                while(++i <n && Character.isDigit(chars[i])) {
                    val += chars[i];
                }
                if (prev == '-' ) {
                    result -= Integer.parseInt(val);
                } else {
                    result += Integer.parseInt(val);
                }
                prev = ' ';
                i--;
            } else {
                prev = ch;
            }
        }
        return result;
    }

    public int calculate2(String s) {

        char[] chars = s.toCharArray();

        char prev = ' ';
        boolean reverseSign = false;
        int result = 0;
        int n = chars.length;
        for (int i = 0; i < n; i++) {
            char ch = chars[i];
            if (ch == ' ')
                continue;
            if (Character.isDigit(ch)){
                String val = "" + ch;
                while(++i <n && Character.isDigit(chars[i])) {
                    val += chars[i];
                }
                System.out.println("operation: " + prev);
                System.out.println("reverseSign: " + reverseSign);
                if (prev == '-' && reverseSign) {
                    System.out.println("+ " + val);
                    result += Integer.parseInt(val);
                } else if (prev == '-' || (prev == '+' && reverseSign)) {
                    System.out.println("- " + val);
                    result -= Integer.parseInt(val);
                } else {
                    result += Integer.parseInt(val);
                }
                prev = ' ';
                i--;
            } else if (ch == '(' && prev == '-') {
                reverseSign = true;
            } else if (ch == ')' && reverseSign) {
                reverseSign = false;
            } else {
                prev = ch;
            }
        }

        return result;
    }
}
