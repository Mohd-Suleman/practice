package ds.stack;

public class CustomStack {
    private int data[];
    private final static int DEFAULT_SIZE = 10;
    private int pointer = -1;
    CustomStack() {
        this(DEFAULT_SIZE);
    }
    CustomStack(int capacity){
        this.data = new int[capacity];
    }

    public int push(int element) throws StackException {
        if(isFull()) {
            int temp[] = new int[data.length*2];
            for(int i=0; i<data.length; i++) {
                temp[i] = data[i];
            }
            data = temp;
        }
        pointer++;
        data[pointer] = element;
        return data[pointer];
    }

    public boolean isFull() {
        boolean flag = false;
        if(data.length-1==pointer) {
            flag = true;
        }
        return flag;
    }   
    public boolean isEmpty() {
        boolean flag = false;
        if(pointer==-1) {
            flag = true;
        }
        return flag;
    }

    public int pop() throws StackException {
        if(isEmpty()) {
            throw new StackException("Stack is empty!!");
        }
        return data[pointer--];
    }

    public void printStack() {
        for(int i=pointer; i>=0; i--) {
            System.out.print(data[i]+" ");
        }
        System.out.println();
    }

    public int size() {
        return pointer+1;
    }
    public int peek() {
        if(!isEmpty())
            return data[pointer];
        return -1;
    }

    public static void main(String arg[]) throws StackException {
        CustomStack stack = new CustomStack();
        System.out.println(stack.push(0));
        System.out.println(stack.push(1));
        System.out.println(stack.push(2));
        System.out.println(stack.push(3));
        System.out.println(stack.push(4));
        System.out.println(stack.push(5));
        System.out.println(stack.push(6));
        System.out.println(stack.push(7));
        System.out.println(stack.push(8));
        System.out.println(stack.push(9));
        System.out.println(stack.push(91));
        System.out.println(stack.push(19));
        System.out.println("Before Stack size "+stack.size());
        System.out.println("Deleting element "+stack.pop());
        System.out.println("Stack size "+stack.size());
        stack.printStack();
        stack.pop();
        System.out.println("Peek element: "+stack.peek());


    }
}