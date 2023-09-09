package leetcode.problems.stacks;

import java.util.Stack;

public class ImplementQueueUsingStacks {
    Stack<Integer> st1;
    Stack<Integer> st2;
    public ImplementQueueUsingStacks() {
        st1 = new Stack(); // 1
        st2 = new Stack(); // 2, 3
    }

    public void push(int x) {
        st1.push(x);
    }

    public int pop() {
        while (!st1.isEmpty()) {
            st2.push(st1.pop());
        }
        int poped = st2.pop();

        while(!st2.isEmpty()) {
            st1.push(st2.pop());
        }
        return poped;
    }

    public int peek() {
        while (!st1.isEmpty()) {
            st2.push(st1.pop());
        }
        int peeked = st2.peek();

        while(!st2.isEmpty()) {
            st1.push(st2.pop());
        }
        return peeked;
    }

    public boolean empty() {
        return st1.isEmpty() && st2.isEmpty();
    }
}

// much better solution from the editorial
class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    public MyQueue() {
        s1 = new Stack();
        s2 = new Stack();
    }

    public void push(int x) {
        while (!s1.isEmpty())
            s2.push(s1.pop());
        s2.push(x);
        while (!s2.isEmpty())
            s1.push(s2.pop());
    }

    public int pop() {
        return s1.pop();
    }

    public int peek() {
        return s1.peek();
    }

    public boolean empty() {
        return s1.isEmpty();
    }
}

