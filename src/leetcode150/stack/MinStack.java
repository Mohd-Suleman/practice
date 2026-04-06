package leetcode150.stack;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    private int minValue;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
        minValue = Integer.MAX_VALUE;
    }

    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || val < minStack.peek() ) {
            minStack.push(val);
        }
    }

    public void pop() {
        int item = stack.pop();
        if(item == minStack.peek())
            minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }


    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
    }


}
