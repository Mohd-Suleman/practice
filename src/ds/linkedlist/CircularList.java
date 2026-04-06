package ds.linkedlist;

public class CircularList {
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
        CircularList list = new CircularList();

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        list.printCircularList();
    }

    public void printCircularList() {
        Node tempNode = head;
        for(int i=0; i<size; i++) {
            System.out.print(tempNode.value+" ");
            tempNode = tempNode.next;
        }
        System.out.println();
    }

    public void insert(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = newNode;
            size++;
            return;
        }
        Node currNode = head;
        for(int i=0; i<size-1; i++) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
        newNode.next = head;
        size++;
    }
}
