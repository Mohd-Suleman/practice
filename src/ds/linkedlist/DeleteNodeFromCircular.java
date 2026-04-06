package ds.linkedlist;

public class DeleteNodeFromCircular {
    Node head;
    int size;
    static class Node {
        int value;
        Node next;
        Node(int value) {
            this.next = null;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        DeleteNodeFromCircular list = new DeleteNodeFromCircular();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        list.printList();
        list.delete(4);
        System.out.println("After deleting");
        list.printList();
        list.insert(6);
        System.out.println("After adding");
        list.printList();
    }

    public void delete(int index) {
        Node currNode = head;
        if(index == 0) {
            head = currNode.next;
            size--;
        }

        for(int i=1; i<index-1; i++) {
            currNode = currNode.next;
        }
        if(index == size-1) {
            currNode.next = head;
        }
        else {
            currNode.next = currNode.next.next;
        }
        size--;
    }

    public void printList() {
        Node tempNode = head;
        for(int i=0; i<size; i++) {
            System.out.print(tempNode.value+" ");
            tempNode = tempNode.next;
        }
    }

    public void insert(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = newNode;
            newNode.next = head;
            size++;
            return;
        }
        Node currNode = head;
        while(currNode.next != null && currNode.next != head) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
        newNode.next = head;
        size++;
    }
}
