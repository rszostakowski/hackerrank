package leetcode.problems.stacks;

import java.util.*;

public class GenerateParentheses {

    public static List<String> generateParenthesisMy(int n) {
        List<String> res = new LinkedList();
        generateParanthesis(res, "", 0, 0, 2*n);
        return res;
    }

    static void generateParanthesis(List<String> result, String str, int left, int right, int n) {
        if (str.length() == n) {
            result.add(str);
            return;
        }

        if (left < n/2) {
            generateParanthesis(result, str + "(", left + 1, right, n);
        }

        if (right < left) {
            generateParanthesis(result, str + ")", left, right +1, n);
        }
    }

    public static void main(String[] args) {
        generateParenthesis(2);
    }

    static Stack<Character> stack = new Stack<>();
    static List<String> res = new ArrayList<>();

    // solution based on stack
    public static  List<String> generateParenthesis(int n) {
        backtrack(0, 0, n);
        return res;
    }

    private static void backtrack(int openN, int closedN, int n) {
        if (openN == closedN && closedN == n) {
            Iterator vale = stack.iterator();
            String temp = "";
            while (vale.hasNext()) {
                temp = temp + vale.next();
            }
            res.add(temp);
        }
        if (openN < n) {
            stack.push('(');
            backtrack(openN + 1, closedN, n);
            stack.pop();
        }
        if (closedN < openN) {
            stack.push(')');
            backtrack(openN, closedN + 1, n);
            stack.pop();
        }
    }
}
