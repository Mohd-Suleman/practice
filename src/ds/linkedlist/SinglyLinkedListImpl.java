package ds.linkedlist;

public class SinglyLinkedListImpl {
    Node head;
    Node tail;
    int size;
    static class Node {
        int value;
        Node next;
        Node tail;

        Node(int value) {
            this.value = value;
            this.next = null;
            this.tail = null;
        }
    }

    public void insert(int value) {
        Node newNode = new Node(value);
        if(tail==null) {
            head=tail=newNode;
            size++;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public void display() {
        Node currentNode = head;
        while(currentNode!=null) {
            System.out.print(currentNode.value+" ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    /**
    Number of iterations -> size/2 --> n/2;
     Complexity O(n);
     */
    public void printMid(int size) {
        Node currentNode = head;
        int mid=size/2+1;
        System.out.println("Mid element: "+mid);
        for(int i=0; i<mid-1; i++) {
            currentNode = currentNode.next;
        }
        System.out.println(currentNode.value);
    }

    public static void main(String arg[]) {
        SinglyLinkedListImpl list = new SinglyLinkedListImpl();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);
        list.insert(60);
        list.insert(70);
//        list.insert(50);
//        list.insert(60);
        list.display();
        System.out.println("Number of elements: "+list.size);
        list.printMid(list.size);


    }
}
