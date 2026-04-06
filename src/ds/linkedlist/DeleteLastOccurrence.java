package ds.linkedlist;

public class DeleteLastOccurrence {
    Node head;
    int size;
    static class Node {
        int data;
        Node next;

        Node(int value) {
            this.data = value;
            this.next = null;
        }
    }
    public static void main(String[] args) {
        DeleteLastOccurrence list = new DeleteLastOccurrence();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);
        list.insert(60);
        list.insert(70);
        list.insert(20);
        list.insert(80);
        list.printList();
        list.deleteLastOccurrence(50);
        list.printList();
    }

    /**
    Concept is:
     Traversing list till end and matching with key
     Maintaining 2 counters.
     currentIndex --> is for iterating till end and incrementing
     lastIndex --> is for holding index of last occurrence of key
     if found then lastIndex = currentIndex;
     */
    public void deleteLastOccurrence(int key) {
        int currentIndex = -1;
        int lastIndex = -1;
        Node currNode = head;
        while(currNode!=null) {
            currentIndex++;
            if(currNode.data == key) {
               lastIndex = currentIndex;
            }
            currNode = currNode.next;
        }
        Node toDeleteNode = head;
        System.out.println("Last Occurrence of "+key+ " is --> "+lastIndex);
        int j = 0;
        while(j<lastIndex-1) {
            toDeleteNode = toDeleteNode.next;
            j++;

        }
        toDeleteNode.next = toDeleteNode.next.next;
    }

    public void printList() {
        Node temp = head;
        while(temp!=null) {
            System.out.print(temp.data+" ");
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
        Node curr = head;
        while(curr.next!=null) {
            curr = curr.next;
        }
        curr.next = newNode;
        size++;
    }
}
