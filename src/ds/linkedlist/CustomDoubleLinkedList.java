package ds.linkedlist;



public class CustomDoubleLinkedList {
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
        Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    public void insertAtFirst(int value) {
        Node newNode = new Node(value);
        if(tail == null) {
            head=tail=newNode;
            size+=1;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        size+=1;
    }

    public void insertAtLast(int value) {
        Node newNode = new Node(value);
        if(tail !=null && tail.next==null) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            tail.next = null;
            size+=1;
        }
    }
    public void insertAtIndex(int value, int index) {
        if(index == 0){
            insertAtFirst(value);
            return;
        } if(index == size-1) {
            insertAtLast(value);
            return;
        }
        Node currentNode = head;
        Node newNode = new Node(value);
        for(int i=0; i<index-1; i++) {
            currentNode = currentNode.next;
        }

        //Note: Order of assignment of below variables are important otherwise you will end up with infinite loop as I previously
        newNode.next = currentNode.next;
        currentNode.next.prev = newNode;
        currentNode.next = newNode;
        newNode.prev = currentNode;
        size+=1;
    }

    public void forwardTraversal(){
        Node tempNode = head;
        while(tempNode!=null){
            System.out.print(tempNode.value+" ");
            tempNode = tempNode.next;
        }
        System.out.println();
    }

    public void backwardTraversal(){
        Node tempNode = tail;
        while(tempNode!=null){
            System.out.print(tempNode.value+" ");
            tempNode = tempNode.prev;
        }
        System.out.println();
    }

    public Node findByElement(int value){
        Node tempNode = head;
        while(tempNode!=null){
            if(tempNode.value == value)
                return tempNode;
            tempNode = tempNode.next;
        }
        return null;
    }

    public Node findByIndex(int index) {
        if(index == 0){
            return head;
        } if(index == size-1) {
            return tail;
        }
        Node currentNode = head;
        for(int i=0; i<index-1; ++i)
            currentNode = currentNode.next;

        return currentNode;
    }

    public void deleteFirst() {
        if(head!=null) {
            head = head.next;
            size-=1;
        }
    }
    public void deleteLast() {
        if(tail != null) {
            tail = tail.prev;
            tail.next = null;
            size-=1;
        }
    }

    public void deleteAtIndex(int index) {
        if(index==0){
            deleteFirst();
            return;
        } if(index==size-1) {
            deleteLast();
            return;
        }
        Node currentNode = head.next;
        for(int i=1; i<index-1; i++) {
            currentNode = currentNode.next;
        }
        currentNode.prev.next = currentNode.next;
        currentNode.next.prev = currentNode.prev;
        size--;
    }
    public static void main(String arg[]) {
        CustomDoubleLinkedList list = new CustomDoubleLinkedList();
        list.insertAtFirst(10);
        list.insertAtLast(20);
        list.insertAtLast(30);
        list.forwardTraversal();
        list.insertAtIndex(100,1);
        list.forwardTraversal();
        list.insertAtIndex(200,2);
        list.forwardTraversal();
        list.insertAtIndex(1,0);
        list.forwardTraversal();
        list.insertAtIndex(1000,5);
        list.forwardTraversal();
        list.backwardTraversal();
        System.out.println(list.findByElement(44));
        System.out.println(list.findByElement(100).value);
        list.deleteFirst();
        list.forwardTraversal();
        list.deleteLast();
        list.forwardTraversal();
        System.out.println(list.size);
        list.deleteAtIndex(1);
        list.insertAtFirst(34);
        list.insertAtFirst(11);
        list.insertAtFirst(33);
        list.forwardTraversal();
        System.out.println(list.findByIndex(0).value);
    }
}
