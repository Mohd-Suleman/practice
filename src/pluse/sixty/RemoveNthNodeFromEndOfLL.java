package pluse.sixty;

public class RemoveNthNodeFromEndOfLL {
    private int size;
    private Node head;
    private Node tail;

    static class Node {
        private int value;
        private Node next;

        Node(int value){
            this.value = value;
            this.next = null;
        }
    }
    RemoveNthNodeFromEndOfLL() {
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

    public void deleteNthFromLast(int position) {
        int index = size - position;

        if(index == 0) {
            head = head.next;
            size--;
        }

        Node currNode = head;
        for(int i = 1; i<index; i++) {
            currNode = currNode.next;
        }
        currNode.next = currNode.next.next;
        printList();
    }

    /**
     * Tutorial: https://www.youtube.com/watch?v=6gI8OMoac4Q
     * Create a dummy Node which will always points to head  --> Not required in this case
     * Take two pointer, firstPointer and secondPointer
     * Initialize both with head
     * Now move the secondPointer by n positions
     * Next move both pointers until secondPointer.next !=null
     * And your firstPointer will point just previous Node that has to be deleted
     * Now delete it by performing firstPointer.next = firstPointer.next.next */
    public void deleteNthFromLastWithoutSize(int position) {
        Node dummy = new Node(Integer.MIN_VALUE);
        dummy.next = head;

        Node firstPointer = head;
        Node secondPointer = head;

        for(int i = 0; i<position; i++) {
            secondPointer = secondPointer.next;
        }

        while(secondPointer.next !=null) {
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next;
        }

        firstPointer.next = firstPointer.next.next;

        printList();
    }



    public static void main(String[] args) {
        RemoveNthNodeFromEndOfLL list = new RemoveNthNodeFromEndOfLL();

        list.insert(10);
        list.insert(8);
        list.insert(15);
        list.insert(9);
        list.insert(13);
        list.insert(6);

        list.printList();

        list.deleteNthFromLastWithoutSize(1);

    }
}
