package pluse.sixty;

public class ValidateParenthesesStack {
    char[] data;
    final static int default_size = 10;
    int pointer = -1;

    public ValidateParenthesesStack() {
        this(default_size);
    }
    public ValidateParenthesesStack(int capacity) {
        this.data = new char[capacity];
    }

    public char peek() {
        if(isEmpty()) {
            System.out.println("Q is empty!!");
            return 0;
        }
        return data[pointer];
    }

    public int pop() {
        if(isEmpty())
            return -1;
        int temp = data[pointer];
        pointer--;
        return temp;
    }


    public void push(char element) {
        if(isFull())
            return;
        pointer++;
        data[pointer] = element;
    }

    public boolean isEmpty() {
        if(pointer == -1) {
            System.out.println("Q is empty!!");
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if(pointer == data.length-1) {
            System.out.println("Q is already full!!");
            return true;
        }
        return false;
    }

    public void printStack() {
        if(isEmpty()) {
            return;
        }
        for(int i=pointer; i>=0; i--) {
            System.out.print(data[i]+" ");
        }
    }



    public static void main(String[] args) {
        ValidateParenthesesStack stack = new ValidateParenthesesStack();
//        System.out.println(stack.isEmpty());
//        System.out.println(stack.isFull());

        System.out.println(stack.validateParentheses("()({{[]}})"));

//        stack.printStack();
    }

    // Just maintain the push and pop orders
    public boolean validateParentheses(String str) {
        boolean flag = true;
        // Write condition to validate if c is other than parentheses.
        for(char c : str.toCharArray()) {
            if(c=='[' || c == '{' || c == '(')
                push(c);
            else {
                char peekElement = peek();
                if(c == ')' && peekElement == '(' || c == '}' && peekElement == '{' || c == ']' && peekElement == '[') {
                    pop();
                } else
                    return false;
            }
        }
        return flag;
    }
}
