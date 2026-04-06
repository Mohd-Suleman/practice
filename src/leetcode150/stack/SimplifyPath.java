package leetcode150.stack;

import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] str) {
        String path = "/../";
        System.out.println("Simplified Path --> "+simplify(path));
    }


    /**
     * Explanation: https://www.youtube.com/watch?v=jFyOrLNvJQM
     * 1. Spill path by /
     * 2. Push Strings in Stack if str is not .., ., blank
     * 3. Pop is str is .. and stack is not empty
     * 4. Iterate over stack and append is SB*/
    public static String simplify(String path) {
        String[] arr = path.split("/");
        Stack<String> stack = new Stack<>();
        for(String str: arr) {
            if(str.equals("..") && !stack.isEmpty())
                stack.pop();
            else if(!str.equals("..") && !str.equals(".") && !str.isEmpty())
                stack.push(str);
        }
        StringBuilder sb = new StringBuilder();

        for(String i: stack)
            sb.append("/").append(i);

        return sb.length() == 0 ? "/" : sb.toString();

    }
}
