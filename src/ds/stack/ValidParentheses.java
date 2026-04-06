package ds.stack;

public class ValidParentheses {
    private char[] data;
    private final static int DEF_SIZE = 10;
    private int end=-1;
    ValidParentheses() {
        this(DEF_SIZE);
    }
    ValidParentheses(int size) {
        this.data = new char[size];
    }

    public static void main(String[] args) {
        ValidParentheses valid = new ValidParentheses();
        System.out.println(valid.validate("[(])"));
    }
    public boolean validate(String str) {
        //Base case
        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if(c == '(' || c == '{' || c == '[') {
                push(c);
            } else {
                char peek = peek();
                //Base case
                if(peek == '(' && c == ')' || peek == '{' && c == '}' || peek == '[' && c == ']') {
                    pop();
                } else
                    return false;
            }
        }
        return true;
    }

    public char peek() {
        return data[end];
    }
    public char pop() {
        //Base condition
        char removed = data[end];
        end--;
        return removed;
    }
    public char push(char c) {
        //Base condition
        end++;
        data[end] = c;
        return data[end];
    }

}
