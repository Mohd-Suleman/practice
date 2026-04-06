package pluse.sixty;

import java.util.LinkedList;
import java.util.Queue;

//Better if you have push operation, poll will take O(n)
public class StackUsingTwoQueue {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public StackUsingTwoQueue() {
        this.q1 = new LinkedList<>();
        this.q2 = new LinkedList<>();
    }

    public void pushToQueue(int element) {
        if(q2.isEmpty())
            q1.add(element);
        else
            q2.add(element);

    }

    public int removeFromQueue() {
        int currentQ1Size = q1.size();
        int currentQ2Size = q2.size();

        int polledElement = -1;

        if(currentQ1Size == 0 && currentQ2Size == 0)
            return polledElement;

        if(currentQ1Size>0) {
            for(int i=0; i<currentQ1Size-1; i++) {
                q2.add(q1.poll());
            }
            polledElement = q1.poll();
        }

        if(currentQ2Size>0) {
            for(int i=0; i<currentQ2Size-1; i++) {
                q1.add(q2.poll());
            }
            polledElement = q2.poll();
        }

        return polledElement;
    }

    public static void main(String[] args) {
        StackUsingTwoQueue queue = new StackUsingTwoQueue();
        queue.pushToQueue(2);
        queue.pushToQueue(3);
        queue.pushToQueue(4);
        queue.pushToQueue(5);

        System.out.println("Elements in Q Before removal: "+queue.q1);
        System.out.println("Polling from Q: "+queue.removeFromQueue());
        System.out.println("Elements in Q1, after removal: "+queue.q1);
        System.out.println("Elements in Q2, after removal: "+queue.q2);

        System.out.println("Polling from Q: "+queue.removeFromQueue());
        System.out.println("Elements in Q1, after removal: "+queue.q1);
        System.out.println("Elements in Q2, after removal: "+queue.q2);

        queue.pushToQueue(6);
        System.out.println("Added new element: ");
        System.out.println("Elements in Q1: "+queue.q1);
        System.out.println("Elements in Q2: "+queue.q2);

        System.out.println("Polling from Q: "+queue.removeFromQueue());
        System.out.println("Elements in Q1: "+queue.q1);
        System.out.println("Elements in Q2: "+queue.q2);


    }
}
