package pluse.sixty.ll;

import java.security.spec.RSAOtherPrimeInfo;

public class SinglyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    private static class Node {
        private int value;
        private Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    SinglyLinkedList() {
        size = 0;
    }

    //This method not required as insert method always adds at last index
    public void insertAtLast(int value) {
        Node newNode = new Node(value);
        if(tail.next == null) {
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }

    public void insertAtFirst(int value) {
        System.out.println("Adding at First: "+value);
        Node newNode = new Node(value);
        if(head != null) {
            newNode.next = head;
            head = newNode;
            size++;
        } else {
            insert(value);
        }
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

    public void printHeadElement(){
        if(head == null) {
            System.out.println("Empty list!!");
            return;
        }
        System.out.println("Head element: "+head.value);
    }

    public void printTailElement(){
        if(tail == null) {
            System.out.println("Empty list!!");
            return;
        }
        System.out.println("Last element: "+tail.value);
    }

    public void printMidElement() {
        if(head == null) {
            System.out.println("Empty list!!");
            return;
        }
        Node tempNode = head;
        int mid = (size/2);
        for(int i=0; i<mid; i++)
            tempNode = tempNode.next;
        System.out.println("Mid Element: "+tempNode.value);

    }

    public void printAllElements() {
        if(head == null) {
            System.out.println("Empty list!!");
            return;
        }
        System.out.println("Printing All Elements: "+size);
        Node tempNode = head;
        while(tempNode!=null) {
            System.out.print(tempNode.value+"->");
            tempNode = tempNode.next;
        }
        System.out.println();
    }

    public void deleteHeadElement() {
        System.out.println("Deleted head element:");
        head = head.next;
        size--;
        printAllElements();
    }

    public void deleteTailElement() {
        System.out.println("Deleted tail element:");
       Node currNode = head;
       for(int i=0; i<size-2; i++)
           currNode = currNode.next;
       tail = currNode;
       tail.next = null;
       size--;

       printAllElements();
    }

    public void deleteAtIndex(int index) {
        System.out.println("Deleted at index :"+index);
        Node currNode = head;
        for(int i=1; i<index; i++)
            currNode = currNode.next;
        currNode.next = currNode.next.next;

        printAllElements();

    }

    //1. Linked can be reversed using Stack, will take extra s
    public void reverseList() {
        Node currNode = head;
        Node preNode = null;

        while(currNode != null) {
            Node nextNode = currNode.next;
            currNode.next = preNode;
            preNode = currNode;
            currNode = nextNode;
        }
        head = preNode;

        Node temp = head;
        while(temp != null) {
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert(5);
        list.insert(8);
        list.insert(2);
        list.insert(6);
        list.insert(9);

        list.printAllElements();

        list.reverseList();

        /*list.insertAtFirst(0);

        list.printAllElements();

        list.printMidElement();

        list.printHeadElement();

        list.printTailElement();

        list.deleteHeadElement();
        list.deleteTailElement();

        list.deleteAtIndex(1);*/
    }
}
