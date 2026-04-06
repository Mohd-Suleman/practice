package ds.linkedlist;

public class RotateAfterNthPosition {
    Node head;
    int size;
    static class Node {
        int value;
        Node next;


        Node(int value) {
            this.value = value;
            this. next = null;
        }
    }

    public static void main(String[] args) {
        RotateAfterNthPosition list = new RotateAfterNthPosition();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);
        list.insert(60);
        list.insert(70);
        list.insert(80);
        System.out.println(list.size);
        list.printList();

    }

    /*public void rotate(int n) {
        Node curr = head;
        for(int i=0; i<n-1; i++) {
            curr =  curr.next;
        }
        System.out.println("Value is: -> "+ curr.value);
        Node last = curr;
        for(int i=n; i<size-1; i++) {
            last.next =  head;
        }
        System.out.println("MidNode is: -> "+ midNode.value);
        head = midNode;
        curr.next = null;
        *//*Node midNode = curr;
        for(int i=n; i<size-1; i++) {
            midNode =  midNode.next;
        }
        System.out.println("MidNode is: -> "+ midNode.value);
        head = midNode;
        curr.next = null;*//*
    }*/

    public void deleteFromLast() {
        Node curr = head;
        for(int i=0; i<size-2; i++) {
            curr = curr.next;
        }
        curr.next = null;
        size--;
    }
    public void printList() {
        Node currentNode = head;
        while(currentNode!=null) {
            System.out.print(currentNode.value+" ");
            currentNode = currentNode.next;
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
        Node currentNode = head;
        while (currentNode.next!=null) {
            currentNode = currentNode.next;
        }
        currentNode.next = newNode;
        size++;
    }
}
