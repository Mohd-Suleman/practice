package leetcode150.ll;

public class CustomSinglyLinkedList {
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

    public CustomSinglyLinkedList() {
        head = null;
        size = 0;
    }

    public void insert(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = newNode;
            size++;
            return;
        }
        Node tempNode = head;
        while(tempNode.next != null)
            tempNode = tempNode.next;
        tempNode.next = newNode;
        size++;
    }

    public void printList() {
        Node tempNode = head;
        System.out.println("List size: "+size);
        while(tempNode != null) {
            System.out.print(tempNode.value+" ");
            tempNode = tempNode.next;
        }
        System.out.println();
    }

    public void printListWithHead(Node head) {
        Node tempNode = head;
        while(tempNode != null) {
            System.out.print(tempNode.value+" ");
            tempNode = tempNode.next;
        }
        System.out.println();
    }

}
