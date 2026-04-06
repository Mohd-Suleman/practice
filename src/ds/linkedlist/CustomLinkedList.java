package ds.linkedlist;

public class CustomLinkedList {
    Node head;
    Node tail;
    int size;
    CustomLinkedList() {
        size = 0;
    }

    public void deleteLast() {

        if(tail != null) {
            Node secondLast = head;
            for(int i=0; i<size-1; i++) {
                secondLast = secondLast.next;
            }
            tail = secondLast;
            tail.next =null;
            size--;
        }
    }
    public void deleteFirst() {
        if(head!=null) {
            head = head.next;
            size -=1;
        }
    }



    public void insertAtIndex(int value, int index) {
       if(index == 0){
           insert(value);
           return;
       }
       Node tempNode = head;
       for(int i=1; i<index; i++) {
           tempNode = tempNode.next;
       }
       Node newNode = new Node(value, tempNode.next);
       tempNode.next = newNode;
       size +=1;
    }

    public void insertAtLast(int value) {
        if(tail == null) {
            insert(value);
            return;
        }
        Node newTailNode = new Node(value);
        tail.next = newTailNode;
        tail = newTailNode;

    }
    public void display() {
        Node temp = head;
        while(temp!=null) {
                System.out.print(temp.data+" ");
                temp = temp.next;
        }
    }
    public void insert(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;

        if(tail == null) {
            tail = newNode;
        }
        size +=1;

    }
    private class Node {
        int data;
        Node next;
        Node(int value) {
            data = value;
            next = null;
        }
        Node(int value, Node node) {
            data = value;
            next = node;
        }

    }

    public static void main(String arg[]) {
        CustomLinkedList list = new CustomLinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        System.out.println(list.size);
        list.insertAtLast(5);
        list.display();

        list.insertAtIndex(35,1);
        System.out.println("\nAfter adding in middle");
        list.display();
        list.deleteFirst();
        System.out.println("\nAfter Deleting 1st element!");
        list.display();
        list.deleteLast();
        System.out.println("\nAfter Deleting last element!");
        list.display();
    }
}
