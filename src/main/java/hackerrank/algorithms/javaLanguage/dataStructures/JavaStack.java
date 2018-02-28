package hackerrank.algorithms.javaLanguage.dataStructures;

import java.util.Scanner;
import java.util.Stack;

public class JavaStack {

    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);

        String input = "}{";
        Stack stack = new Stack();
        input.chars()
                .mapToObj(i -> (char) i)
                .map(el -> Character.toString(el))
                .forEach(el -> checkIfPreviousTheSame(stack, el));
        System.out.println(stack.empty());
    }

    private static void checkIfPreviousTheSame(Stack stack, String right) {
        String revertedEl = revert(right);
        if (!stack.isEmpty()
                && stack.peek().equals(revertedEl)
                && (stack.peek().equals("(") || stack.peek().equals("[") || stack.peek().equals("{"))) {
            stack.pop();
        } else {
            stack.push(right);
        }
    }

    private static String revert(String el) {
        switch (el) {
            case "(":
                return ")";
            case ")":
                return "(";
            case "[":
                return "]";
            case "]":
                return "[";
            case "{":
                return "}";
            case "}":
                return "{";
            default:
                throw new RuntimeException();
        }
    }
}
/*

true
false
true
false
false
false
false
false
true
true
false

({}[])
(({()})))
({(){}()})()({(){}()})(){()}
{}()))(()()({}}{}
}}}}
))))
{{{
(((
[]{}(){()}((())){{{}}}{()()}{{}{}}
[[]][][]
}{
 */
