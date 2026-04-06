package ds.linkedlist;

public class DetectCycle {
    Node head;
    int size;
    static class Node {
        int value;
        Node next;
        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        DetectCycle list = new DetectCycle();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.printList();
        list.createSingularToCircular();
        System.out.println(list.detectLoop());
    }


    /**
     *Create loop by using Node.next....
     */
    public void createSingularToCircular() {
        head.next.next.next.next.next = head.next;
    }

    /**
     * Using Floyd’s Cycle-Finding Algorithm – O(n) Time and O(1) Space
     * Traverse linked list using two pointers.
     * Move one pointer(slow) by one step ahead and another pointer(fast) by two steps ahead.
     * If these pointers meet at the same node then there is a loop. If pointers do not meet then the linked list doesn’t have a loop.
     */
    public boolean detectLoop() {
        Node slowNode = head;
        Node fastNode = head;
        while(slowNode != null && fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            System.out.println(slowNode.value+" : "+ fastNode.value);
            if(slowNode.value == fastNode.value)
                return true;
        }
        return false;
    }

    public void printList() {
        Node tempNode = head;
        while(tempNode!=null) {
            System.out.print(tempNode.value+" ");
            tempNode = tempNode.next;
        }
        System.out.println();
    }

    public void insert(int value) {
        Node newNode = new Node(value);
        if(head==null) {
            head = newNode;
            size++;
            return;
        }
        Node currNode = head;
        while(currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
        size++;
    }
}
