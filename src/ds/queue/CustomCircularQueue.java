package ds.queue;

public class CustomCircularQueue {
   private int data[];
   private final static int DEF_SIZE = 5;
   private int size;
   private int front, end;
   CustomCircularQueue() {
       this(DEF_SIZE);
   }

    CustomCircularQueue(int capacity) {
       this.data = new int[capacity];
       front = 0;
       end = 0;
       size = 0;
    }

    public static void main(String[] args) {
        CustomCircularQueue queue = new CustomCircularQueue();
        queue.insert(10);
        queue.insert(20);
        queue.insert(30);
        queue.insert(40);
        queue.insert(50);

        queue.display();
        queue.remove();
        queue.display();

        queue.insert(100);

        queue.display();


    }

    public void display() {
       int i = front;
       do {
           System.out.print(data[i]+" ");
           i++;
           i = i % data.length;
       } while(i != end);
        System.out.println("--> End");
    }
    public boolean remove() {
       if(size == 0) {
           System.out.println("Queue is empty!!");
           return false;
       }
       front++;
       front = front % data.length;
       size--;
       return true;

    }

    public boolean insert(int element) {
       if(data.length == size) {
           System.out.println("Queue is full!!");
           return false;
       }
       data[end++] = element;
       end = end % data.length;
       size++;
       return true;
    }

    public void dynamicInsert(int element) {
       if(data.length == size) {
           int temp[] = new int[data.length*2];
           for(int i=0; i<data.length; i++) {
               temp[i] = data[(front+i)%data.length];
           }
           front = 0;
           end = data.length;
           data = temp;
           data[end++] = element;
           size++;
       }
    }
}
