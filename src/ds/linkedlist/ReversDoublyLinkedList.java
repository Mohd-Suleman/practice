package ds.linkedlist;

public class ReversDoublyLinkedList {
    Node head;
    Node tail;
    int size;
    static class Node {
        int value;
        Node next;
        Node prev;
        Node(int value) {
            this.value = value;
            next = null;
            prev = null;
        }
    }

    public void insert(int value) {
        Node newNode = new Node(value);
        if(head==null) {
            head=tail=newNode;
            size++;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        tail.next = null;
        size++;
    }

    public void print() {
        Node currentNode = head;
        while(currentNode!=null) {
            System.out.print(currentNode.value+" ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    public Node reversList() {
        Node currentNode = head;
        Node prev = null;
        Node next = null;

        while(currentNode != null) {
            next = currentNode.next;
            currentNode.next=prev;
            prev = currentNode;
            currentNode = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ReversDoublyLinkedList list = new ReversDoublyLinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.print();
        list.reversList();
        list.print();

    }
}
