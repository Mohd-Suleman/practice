package ds.linkedlist;

public class DeleteMidElement {
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

    public static void main(String[] args) {
        DeleteMidElement list = new DeleteMidElement();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);

        list.printList();
        list.deleteMiddle();
        list.printList();
    }

    public void deleteMiddle() {
        int mid = 1+size/2;
        Node currNode = head;
        for(int i=0; i<mid-2; i++) {
            currNode = currNode.next;
        }
        currNode.next = currNode.next.next;

    }
    public void printList() {
        Node temp = head;
        while(temp!=null) {
            System.out.print(temp.value+" ");
            temp = temp.next;
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
        Node currNode = head;
        while(currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
        size++;
    }


}
