package pluse.sixty.ll;

public class CircularSinglyLinkedList {
    private int size;
    private Node head;
    private Node tail;

    static class Node {
        private int value;
        private Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    CircularSinglyLinkedList() {
        size = 0;
    }

    public void insert(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = tail = newNode;
            size++;
        }
        tail.next = newNode;
        tail = newNode;
        tail.next = null;
        size++;
    }

    public void printList() {
        Node tempNode = head;
        while(tempNode != null) {
            System.out.print(tempNode.value+" ");
            tempNode = tempNode.next;
        }
        System.out.println();
    }

    //Enhance this to pass indexes
    public void convertToCircular() {
        tail.next = head.next;
    }

    public boolean detectLoop() {
        Node slow = head;
        Node fast = head;

        while(fast.next != null && slow.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow.value == fast.value){
                System.out.println("Loop detected at -> "+slow.value+":"+fast.next.value);
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        CircularSinglyLinkedList list = new CircularSinglyLinkedList();

        list.insert(5);
        list.insert(9);
        list.insert(3);
        list.insert(11);
        list.insert(1);

        list.printList();

        list.convertToCircular();

        list.detectLoop();
    }

}
