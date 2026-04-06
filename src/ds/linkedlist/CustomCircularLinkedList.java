package ds.linkedlist;

public class CustomCircularLinkedList {
    Node head;
    Node tail;
    int size;
    static class Node {
        int value;
        Node next;
        Node(int value) {
            this.value = value;
        }
        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public void insert(int value) {
        Node newNode = new Node(value);
        if(tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
        size++;
    }

    public void display() {
        Node tempNode = head;
        for(int i=0; i<size; i++) {
            System.out.print(tempNode.value+" ");
            tempNode = tempNode.next;
        }
        System.out.println();
    }

    public void deleteHead() {
        if(head!=null) {
            head = head.next;
            tail.next = head;
        }
    }

    public static void main(String[] args) {
        CustomCircularLinkedList list = new CustomCircularLinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.display();
        list.deleteHead();
        list.display();
    }
}
