package pluse.sixty;

import java.util.Stack;

public class QueueUsingTwoStack {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public QueueUsingTwoStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

   public void pushToStack(int element) {
        if(s2.isEmpty())
            s1.push(element);
        else {
            int currentS2Size = s2.size();
            for(int i=0; i<currentS2Size; i++) {
                s1.push(s2.pop());
            }
            s1.push(element);
        }
    }

    public int removeFromStack() {
        int currentS1Size = s1.size();
        int currentS2Size = s2.size();

        int poppedElement = -1;
        if(currentS1Size>0) {
            for(int i=0; i<currentS1Size-1; i++) {
                s2.push(s1.pop());
            }
            poppedElement = s1.pop();
        }

        if(currentS2Size>0) {
            poppedElement = s2.pop();
        }
        return poppedElement;
    }

    public static void main(String[] args) {
        QueueUsingTwoStack queueUsingTwoStack = new QueueUsingTwoStack();
        queueUsingTwoStack.pushToStack(10);
        queueUsingTwoStack.pushToStack(20);
        queueUsingTwoStack.pushToStack(30);
        queueUsingTwoStack.pushToStack(40);
        queueUsingTwoStack.pushToStack(50);

        System.out.println(queueUsingTwoStack.s1);
        System.out.println(queueUsingTwoStack.s2);

        System.out.println("Poll: "+queueUsingTwoStack.removeFromStack());
        System.out.println(queueUsingTwoStack.s1);
        System.out.println(queueUsingTwoStack.s2);

        System.out.println("Poll: "+queueUsingTwoStack.removeFromStack());
        System.out.println(queueUsingTwoStack.s1);
        System.out.println(queueUsingTwoStack.s2);
        System.out.println("Poll: "+queueUsingTwoStack.removeFromStack());
        queueUsingTwoStack.pushToStack(25);
        System.out.println("Poll: "+queueUsingTwoStack.removeFromStack());

        queueUsingTwoStack.pushToStack(60);

        System.out.println(queueUsingTwoStack.s1);
        System.out.println(queueUsingTwoStack.s2);

        System.out.println("Poll: "+queueUsingTwoStack.removeFromStack());
        System.out.println("Poll: "+queueUsingTwoStack.removeFromStack());
    }

}
