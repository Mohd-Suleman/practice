package ds.stack;

public class ReverseArray {
    private int data[];
    private final static int DEFAULT_SIZE = 5;
    private int end = -1;

    ReverseArray() {
        this(DEFAULT_SIZE);
    }
    ReverseArray(int capacity) {
        this.data = new int[capacity];
    }

    public static void main(String[] args) throws Exception {
        ReverseArray stack = new ReverseArray();
        int[] arr = {1,2,3,4};
        System.out.print("Initial array: -> ");
        for(int i: arr)  {
            System.out.print(i+" ");
        }
        System.out.print("\nReverse using stack: -> ");
        for(int i: stack.reversArray(arr))  {
            System.out.print(i+" ");
        }
    }
    public int[] reversArray(int arr[]) throws Exception {
        for(int a: arr) {
            push(a);
        }
        int[] newArray = new int[arr.length];
        for(int i=0; i<arr.length; i++) {
            newArray[i] = pop();
        }
        return newArray;
    }

    public int push(int element) throws Exception {
        if(end == data.length-1) {
            throw new Exception("Stack is Overflow!!");
        }
        end++;
        data[end] = element;
        return data[end];
    }

    public int pop() throws Exception {
        if (end == -1) {
            throw new Exception("Stack is Underflow!!");
        }
        int removed = data[end];
        end--;
        return removed;
    }

    public int peek() throws Exception {
        if(end == data.length-1) {
            throw new Exception("Stack is Overflow!!");
        }
        return data[end];
    }

    public void printStack() {
        for(int i=end; i>=0; i--) {
            System.out.print(data[i]+" ");
        }
        System.out.println("--> END");
    }
}
