class CustomQueue {
    private int front;
    private int rear;
    int capacity = 10;
    int[] queue = new int[capacity];
    public CustomQueue() {
        front = -1;
        rear = -1;
    }



    void enqueue(int element) {
        if(front == -1) {
            front++;
        }
        if(rear == capacity-1) {
            System.out.println("Queue is already full!!");
            return;
        }

        queue[rear++] = element;
    }


}

public class CustomQueueImpl {
    public static void main(String arg[]) {
         CustomQueue queue = new CustomQueue();
         queue.enqueue(1);
         queue.enqueue(2);
         System.out.println("Adding one more...");
//        queue.enqueue(3);
    }
}
