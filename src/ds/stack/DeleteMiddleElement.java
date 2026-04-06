package ds.stack;

import java.util.ArrayList;
import java.util.List;

public class DeleteMiddleElement {
    private int data[];
    private final static int DEFAULT_SIZE = 10;
    private int end = -1;

    DeleteMiddleElement() {
        this(DEFAULT_SIZE);
    }
    DeleteMiddleElement(int capacity) {
        data = new int[capacity];
    }

    public static void main(String[] args) throws Exception {
        DeleteMiddleElement stack = new DeleteMiddleElement();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack.printStack();

        stack.deleteMiddle(stack);

        stack.printStack();

    }
    public void deleteMiddle(DeleteMiddleElement stack) throws Exception {
        List<Integer> list = new ArrayList<>();
        int mid = 1+data.length/2;
        System.out.println(mid);

        while(!stack.isEmpty()) {
            list.add(stack.pop());
        }
        System.out.println(list);

        for(int i=list.size()-1; i>=0; i--) {
            if(i==mid){
                continue;
            }
            push(list.get(i));
        }
    }
    public boolean isEmpty() {
        boolean flag = false;
        if(end == -1)
            flag = true;
        return flag;
    }
    public void printStack() {
        for(int i=end; i>=0; i--) {
            System.out.print(data[i]+" ");
        }
        System.out.println();
    }

    public int pop() throws Exception {
        if(end == -1) {
            throw new Exception("Stack Overflow!!");
        }
        int removed = data[end];
        end--;
        return removed;
    }

    public int push(int element) throws Exception {
        if(end == data.length-1) {
            throw new Exception("Stack Underflow!!");
        }
        end++;
        data[end] = element;
        return data[end];
    }
}
