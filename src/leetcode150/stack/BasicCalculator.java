package leetcode150.stack;

import java.util.Stack;

public class BasicCalculator {
    public static void main(String[] args) {
        String s = " 2-1+2 ";
        System.out.println("Calculator output: "+calculate(s));
    }

    /**
     * Explanation: https://www.youtube.com/watch?v=sfM4DjMfhw4
     * BitBucket: https://github.com/Ayu-99/Data-Structures/blob/master/Leetcode%20Challenge/December/Basic%20Calculator%20II.cpp
     * Advance : https://www.youtube.com/watch?v=-x1mBBPxQh4*/
    public static int calculate(String expression) {
        int len = expression.length();
        if(len < 2)
            return -1;

        Stack<Integer> numStack = new Stack<>();
        char lastOperation = '+';
        int currentNumber = 0 ;
        for(int i=0; i<len; i++) {
            char c  = expression.charAt(i);
            if(Character.isDigit(c)) {
                currentNumber = (currentNumber * 10) + (c - '0');
            }
            if(!Character.isDigit(c) && !Character.isWhitespace(c) || i == len-1) {
                if(lastOperation == '+')
                    numStack.push(currentNumber);
                else if(lastOperation == '-')
                    numStack.push(-currentNumber);
                else if(lastOperation == '*') {
                    numStack.push(numStack.pop() * currentNumber);
                }
                else if(lastOperation == '/') {
                    numStack.push(numStack.pop() * currentNumber);
                }
                currentNumber = 0;
                lastOperation = c;
            }

        }
        int sum = 0;
        for(int i: numStack)
            sum += i;
        return sum;
    }
}
