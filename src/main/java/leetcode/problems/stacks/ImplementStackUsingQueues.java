package leetcode.problems.stacks;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {
    Queue<Integer> first;
    Queue<Integer> second;
    public ImplementStackUsingQueues() {
        first = new LinkedList();
        second = new LinkedList();
        boolean left = true;
    }

    public void push(int x) {
        // 1 2 3
        first.add(x);

        // 3
        // 1 2
    }

    public int pop() {
        while (first.size() != 1) {
            int val = first.poll();
            second.add(val);
        }
        int returned = first.poll();

        while (second.size() != 0) {
            int val = second.poll();
            first.add(val);
        }

        return returned;
    }

    public int top() {
        int val = pop();
        first.add(val);
        return val;
    }

    public boolean empty() {
        return first.size() == 0 && second.size() == 0;
    }
}
