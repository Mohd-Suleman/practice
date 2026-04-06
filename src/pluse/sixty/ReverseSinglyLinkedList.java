package pluse.sixty;

import java.security.spec.RSAOtherPrimeInfo;

public class ReverseSinglyLinkedList {
    private int size;
    private Node head;
    private Node tail;

    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    ReverseSinglyLinkedList() {
        size = 0;
    }

    public void insert(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = tail = newNode;
            size++;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        tail.next = null;
        size++;
    }


    public void printList() {
        Node tempNode = head;
        while(tempNode!=null) {
            System.out.print(tempNode.value+"->");
            tempNode = tempNode.next;
        }
        System.out.println();

    }

    public void reverse() {
        //base case

        Node curNode = head;
        Node preNode = null;

        while(curNode != null) {
            Node nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        System.out.print("Reversed list: ");
        head = preNode;

        printList();
    }

    public static void main(String[] args) {
        ReverseSinglyLinkedList list = new ReverseSinglyLinkedList();

        list.insert(10);
        list.insert(8);
        list.insert(15);
        list.insert(9);

        list.printList();

        list.reverse();
    }

}
