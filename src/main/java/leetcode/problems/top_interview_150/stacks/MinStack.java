package leetcode.problems.top_interview_150.stacks;

import java.util.*;

public class  MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        minStack.top();      // Output: 2147483647
        minStack.pop();
        minStack.getMin();   // Output: 2147483646
        minStack.pop();
        minStack.getMin();   // Output: 2147483646
        minStack.pop();
        minStack.push(2147483647);
        minStack.top();      // Output: 2147483647
        minStack.getMin();   // Output: 2147483647
        minStack.push(-2147483648);
        minStack.top();      // Output: -2147483648
        minStack.getMin();   // Output: -2147483648
        minStack.pop();
        minStack.getMin();   // Output: 2147483647
    }
    List<Integer> list;
    int counter = -1;
    int min  = Integer.MAX_VALUE;
    public MinStack() {
        list = new LinkedList<>();
    }

    public void push(int val) {
        list.add(val);
        min = Math.min(val, min);
        counter++;
    }

    public void pop() {
        int removed = list.remove(counter--);
        if (removed == min) {
            Optional<Integer> minOpt = list.stream().min(Integer::compareTo);
            if(!minOpt.isPresent()) {
                System.out.println("EMPTY");
            }
            min = minOpt.orElse(Integer.MAX_VALUE);
        }
    }
    public int top() {
        return list.get(counter);
    }

    public int getMin() {
        return min;
    }
}
