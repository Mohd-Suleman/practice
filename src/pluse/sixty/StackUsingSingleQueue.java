package pluse.sixty;

import java.util.LinkedList;
import java.util.Queue;

//Better if you have pop operation, push will take O(n)
public class StackUsingSingleQueue {

    private Queue<Integer> queue;

    public StackUsingSingleQueue() {
        queue = new LinkedList<>();
    }

    public void pushToQueue(int element) {
        queue.add(element);
        for(int i=1; i<queue.size(); i++) {
            queue.add(queue.remove());
        }
    }

    public static void main(String[] args) {
        StackUsingSingleQueue stackUsingSingleQueue = new StackUsingSingleQueue();

        stackUsingSingleQueue.pushToQueue(1);
        stackUsingSingleQueue.pushToQueue(2);
        stackUsingSingleQueue.pushToQueue(3);
        stackUsingSingleQueue.pushToQueue(4);
        stackUsingSingleQueue.pushToQueue(5);
        stackUsingSingleQueue.pushToQueue(6);
        stackUsingSingleQueue.pushToQueue(7);

        System.out.println(stackUsingSingleQueue.queue);
    }
}
