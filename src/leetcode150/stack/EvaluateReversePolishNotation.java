package leetcode150.stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println("Reversed Polish Notation: "+evaluate(tokens));
    }

    //Explanation: https://www.youtube.com/watch?v=vvnaANhNSes
    public static int evaluate(String[] tokens) {
        if(tokens.length < 3)
            return -1;
        Stack<Integer> stack = new Stack<>();

        String operators = "+-*/";

        for(String str: tokens) {

            if(operators.contains(str)) {
                int operand1 = stack.pop();
                int operand2 = stack.pop();
                int res = 0;

                /*switch (str) {
                    case "+":
                        res = operand1 + operand2;
                        break;
                    case "-":
                        res = operand1 - operand2;
                        break;
                    case "*":
                        res = operand1 * operand2;
                        break;
                    case "/":
                        res = operand1 / operand2;
                        break;
                }*/


                if("+".equals(str))
                    res = operand2 + operand1;
                else if("-".equals(str))
                    res = operand2 - operand1;
                else if("*".equals(str))
                    res = operand2 * operand1;
                else if("/".equals(str))
                    res = operand2 / operand1;
                stack.push(res);

            } else {
                stack.push(Integer.parseInt(str));
            }

        }
        return stack.pop();
    }
}
