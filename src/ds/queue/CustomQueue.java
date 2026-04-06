package ds.queue;

public class CustomQueue {
    private int[] data;
    private static final int DEFAULT_CAPACITY = 10;
    private int end = 0;

    CustomQueue() {
        this(DEFAULT_CAPACITY);
    }
    CustomQueue(int size) {
        this.data = new int[size];
    }

    public boolean insert(int element) throws Exception{
        if(isFull()) {
            throw new Exception("Queue is full!!");
        }
        data[end++] = element;
        return true;
    }

    public void print() {
        for(int i=0; i<end; i++) {
            System.out.print(data[i]+" ");
        }
        System.out.println();
    }


    public boolean isFull() {
        boolean flag = false;
        if(end==data.length)
            flag = true;
        return flag;
    }
    public boolean isEmpty() {
        boolean flag = false;
        if(end==0)
            flag = true;
        return flag;
    }

    public boolean removeHead() throws Exception {
        if(isEmpty())
            throw new Exception("Queue is empty!!");
        int remove = data[0];
        for(int i=1; i<data.length; i++) {
            data[i-1] = data[i];
        }
        end--;
        return true;

    }

    public static void main(String[] args) throws Exception {
        CustomQueue queue = new CustomQueue();
        queue.insert(10);
        queue.insert(20);
        queue.insert(30);
        queue.insert(40);
        queue.insert(50);
        queue.print();
        queue.removeHead();
        queue.print();
    }
}
