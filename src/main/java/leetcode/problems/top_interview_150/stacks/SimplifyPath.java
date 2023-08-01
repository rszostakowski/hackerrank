package leetcode.problems.top_interview_150.stacks;

import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack();
        String[] parts = path.split("/");

        for (String part : parts) {
            if (!part.equals("/") && part.length() != 0) {
                if (part.equals("..") && !st.isEmpty()) {
                    st.pop();
                } else if(!part.equals(".") && !part.equals("..")) {
                    st.push(part);
                }
            }
        }


        if (st.isEmpty()) {
            return "/";
        }

        String res = "";
        while(!st.isEmpty()) {
            res =    "/"  + st.pop()  + res;
        }
        return res;
    }
}
