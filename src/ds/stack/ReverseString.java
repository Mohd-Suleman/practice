package ds.stack;

import jdk.swing.interop.SwingInterOpUtils;

public class ReverseString {
    private char data[];
    private static final int DEF_SIZE = 10;
    private int end=-1;

    ReverseString() {
        this(DEF_SIZE);
    }
    ReverseString(int size) {
        this.data = new char[size];
    }

    //Main method
    public static void main(String[] args) {
        ReverseString stack = new ReverseString();
        System.out.println(stack.reverse("SALMA"));;
    }
    public String reverse(String str) {
        StringBuilder builder = new StringBuilder();
        //Pushing every char into stack
        for(int i=0; i<str.length(); i++) {
            push(str.charAt(i));
        }
        //Pop and append
        for(int i=end; i>=0; i--) {
            builder.append(pop());
        }
        return builder.toString();

    }
    public char pop() {
        //Base condition
        char removed = data[end];
        end--;
        return removed;

    }
    public boolean push(char c) {
        //Base condition
        end++;
        data[end] = c;
        return true;
    }

    public void printStack() {
        System.out.println("Printing stack ->>");
        for(int i=0; i<end; i++) {
            System.out.print(data[i]+" ");
        }
        System.out.println();
    }
}
